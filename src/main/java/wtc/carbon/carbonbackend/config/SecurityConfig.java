package wtc.carbon.carbonbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebMvc
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 先允许所有的请求
        return http
                // CORS 配置
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfig = new org.springframework.web.cors.CorsConfiguration();
                    corsConfig.addAllowedOrigin("http://localhost:3000");
                    corsConfig.addAllowedOrigin("http://localhost:3001");
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
                        .anyRequest().permitAll()
                ).build();
    }
}
