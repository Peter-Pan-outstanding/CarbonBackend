package wtc.carbon.carbonbackend.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import wtc.carbon.carbonbackend.util.JwtUtil;

import java.io.IOException;

@Component
public class JwtAuthorizeFilter extends OncePerRequestFilter {
    @Resource
    private JwtUtil util;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        DecodedJWT jwt = util.decode(authHeader);

        // 如果 JWT 存在且有效，将其转换为 Spring Security 的认证信息
        if (jwt != null){
            // 这里没有做错误处理，因为如果写了，jwt校验失败了，就不让他继续进行了
            // 后续登录过，但是token失效的用户再访问公开的端口时也会触发
            UserDetails user = util.toUserDetails(jwt);
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            // 将认证信息放入 Spring Security 上下文中
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        // 继续传递请求
        filterChain.doFilter(request, response);
    }
}

