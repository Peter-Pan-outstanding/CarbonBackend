package wtc.carbon.carbonbackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CarbonReduction {
    private Long id;
    private String projectName;
    private Double investmentAmount;
    private Double originalCarbonEmission;
    private Double reducedCarbonEmission;
    private LocalDateTime reportTime;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
