package wtc.carbon.carbonbackend.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

@Data
public class ProductionPlan {
    private Integer id;
    private String date;        // 日期
    private Integer production; // 生产量
    private Integer target;     // 目标生产量
    @JsonIgnore
    private LocalDateTime createdAt;
    @JsonIgnore
    private LocalDateTime updatedAt;
}
