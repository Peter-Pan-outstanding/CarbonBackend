package wtc.carbon.carbonbackend.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

@Data
public class SalesStatistics {
    private Integer id;
    private String date;       // 销售日期
    private Integer sales;     // 销售额
    @JsonIgnore
    private LocalDateTime createdAt;
    @JsonIgnore
    private LocalDateTime updatedAt;
}
