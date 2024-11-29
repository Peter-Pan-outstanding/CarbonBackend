package wtc.carbon.carbonbackend.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

@Data
public class Salesperson {
    private Integer id;
    private String name;   // 销售人员姓名
    private Integer value;  // 销售金额
    @JsonIgnore
    private LocalDateTime createdAt;
    @JsonIgnore
    private LocalDateTime updatedAt;
}
