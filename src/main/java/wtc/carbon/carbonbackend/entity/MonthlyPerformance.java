package wtc.carbon.carbonbackend.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

@Data
public class MonthlyPerformance {
    private Integer id;
    private String month;
    private Integer visits;
    private Integer orders;
    @JsonIgnore
    private LocalDateTime createdAt;
    @JsonIgnore
    private LocalDateTime updatedAt;
}
