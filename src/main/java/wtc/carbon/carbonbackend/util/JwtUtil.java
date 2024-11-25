package wtc.carbon.carbonbackend.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtUtil {
    @Value("${spring.security.jwt.key}")
    String key;

    // 本项目的单位为天
    @Value("${spring.security.jwt.expire}")
    public int expire;


    // 获取失效时间
    public Calendar getExpireTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, expire*24);
        return calendar;
    }

    // 创建token，实际上就是字符串
    // 创建JWT时，添加 userType 字段来区分Admin和User
    public String createJwt(UserDetails details, Integer id, String username, String userType, String role) {
        Algorithm algorithm = Algorithm.HMAC256(key); // 指定加密算法

        List<String> authorities = Optional.ofNullable(details)
                .map(UserDetails::getAuthorities)
                .orElse(Collections.emptyList())   // 如果 getAuthorities() 返回 null，替换为空集合
                .stream()
                .map(authority -> Optional.ofNullable(authority.getAuthority()).orElse("")) // 确保 authority 不为 null
                .toList();

        return JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withClaim("id", id)
                .withClaim("username", username)
                .withClaim("userType", userType)
                .withClaim("role", role) // 权限，目前只有admin表有
                .withClaim("authorities", authorities)
                .withExpiresAt(getExpireTime().getTime())
                .withIssuedAt(new Date())
                .sign(algorithm);
    }

    // 将JWT的转换为SpringSecurity的 UserDetails
    /*public UserDetails toUserDetails(DecodedJWT decodedJWT) {
        Map<String, Claim> claims = decodedJWT.getClaims();
        String userType = claims.get("userType").asString();
        if ("admin".equals(userType)) {
            return toAdmin(decodedJWT);  // 根据角色返回Admin对象
        } else if ("user".equals(userType)) {
            return toRegularUser(decodedJWT);  // 返回普通User对象
        }
        throw new RuntimeException("用户类型错误");
    }*/

    // 转换成 UserDetails 的实现类
    // 转换为Admin
/*    private UserDetails toAdmin(DecodedJWT decodedJWT) {
        Map<String, Claim> claims = decodedJWT.getClaims();
        return new Admin(claims.get("username").asString(),claims.get("role").asString());
    }*/

    // 转换为User
/*    private UserDetails toRegularUser(DecodedJWT decodedJWT) {
        Map<String, Claim> claims = decodedJWT.getClaims();
        return new com.zjj.shoppingweb.entity.User(claims.get("username").asString());
    }*/

    // 将前端的请求转换为jwt
    public DecodedJWT decode(String headerToken) {
        String token = convertToken(headerToken);
        if (token == null) {
            return null;
        }

        Algorithm algorithm = Algorithm.HMAC256(key);
        JWTVerifier verifier = JWT.require(algorithm).build();

        try {
            // 验证 token 是否有效
            DecodedJWT decodedJWT = verifier.verify(token);

            // 检查 token 是否过期
            Date expiresAt = decodedJWT.getExpiresAt();
            if (expiresAt != null && new Date().after(expiresAt)) {
                return null; // Token 已过期
            }

            return decodedJWT; // 返回有效的 decodedJWT
        } catch (JWTVerificationException e) {
            // 验证失败，返回 null
            return null;
        }
    }


    // 將請求頭變成token
    private String convertToken(String headerToken){
        if (headerToken == null){
            return null;
        }
        if(headerToken.startsWith("Bearer ")){
            return headerToken.substring(7);
        }
        return null;
    }

}
