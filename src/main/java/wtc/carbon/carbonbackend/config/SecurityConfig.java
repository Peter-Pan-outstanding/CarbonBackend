package wtc.carbon.carbonbackend.config;

import com.google.gson.Gson;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import wtc.carbon.carbonbackend.common.AuthorizeVO;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.Admin;
import wtc.carbon.carbonbackend.filter.JwtAuthorizeFilter;
import wtc.carbon.carbonbackend.mapper.AdminMapper;
import wtc.carbon.carbonbackend.util.JwtUtil;

import java.io.IOException;

@Configuration
@EnableWebMvc
public class SecurityConfig {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private JwtAuthorizeFilter jwtAuthorizeFilter;

    @Resource
    private Gson gson;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Admin admin = adminMapper.getAdminByUsername(username);
            if (admin == null) {
                throw new UsernameNotFoundException(username);
            }
            return admin;
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 先允许所有的请求
        return http
                .userDetailsService(userDetailsService())
                // CORS 配置
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfig = new org.springframework.web.cors.CorsConfiguration();
                    corsConfig.addAllowedOrigin("http://localhost:3000");
                    corsConfig.addAllowedMethod("GET");
                    corsConfig.addAllowedMethod("POST");
                    corsConfig.addAllowedMethod("PUT");
                    corsConfig.addAllowedMethod("DELETE");
                    corsConfig.addAllowedHeader("*");
                    corsConfig.setAllowCredentials(true);
                    return corsConfig;
                }))
                // 禁用 CSRF 防护
                .csrf(AbstractHttpConfigurer::disable)
                // 配置会话管理，使用无状态 session
                .sessionManagement(conf -> conf
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(conf -> conf
                        .anyRequest().authenticated()
                )
                .formLogin(conf -> conf
                        .loginProcessingUrl("/auth/login")
                        .successHandler(this::onAuthenticationSuccess)
                        .failureHandler(this::onAuthenticationFailure)
                )
                // 配置异常处理
                .exceptionHandling(conf -> conf
                        .authenticationEntryPoint(this::onUnauthorized) // 未授权处理
                )

                // 添加 JWT 授权过滤器
                .addFilterBefore(jwtAuthorizeFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    private void onUnauthorized(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(gson.toJson(new Result<>(HttpServletResponse.SC_FORBIDDEN, "未授权", null)));
    }


    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Admin admin = adminMapper.getAdminByUsername(userDetails.getUsername());
        String token = jwtUtil.createJwt(userDetails, admin.getId(), admin.getUsername());

        AuthorizeVO vo = new AuthorizeVO(admin.getId(), admin.getUsername(), token);
        response.getWriter().write(gson.toJson(Result.success("登录成功", vo)));
    }

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(401);
        response.getWriter().write(gson.toJson(Result.error(401, "登录失败，用户名或密码错误")));
    }


}
