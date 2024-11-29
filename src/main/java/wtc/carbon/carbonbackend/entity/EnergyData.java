package wtc.carbon.carbonbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EnergyData {
    private Integer id;
    private String dataCategory;
    private String name;
    private String description;
    private Double value;
    private String unit;
    @JsonIgnore
    private LocalDateTime createdAt;
    @JsonIgnore
    private LocalDateTime updatedAt;
}
