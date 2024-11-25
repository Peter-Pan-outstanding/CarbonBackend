package wtc.carbon.carbonbackend.common;

import lombok.Data;

@Data
public class AuthorizeVO {
    private Integer id;
    private String username;
    private String role; // 给admin表准备的
    private String token;
    private Double balance;

    public AuthorizeVO(Integer id, String username, String role, String token, Double balance) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.token = token;
        this.balance = balance;
    }

}
