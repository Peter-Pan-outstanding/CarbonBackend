package wtc.carbon.carbonbackend.common;

import lombok.Data;

@Data
public class AuthorizeVO {
    private Integer id;
    private String username;
    private String token;

    public AuthorizeVO(Integer id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }

}
