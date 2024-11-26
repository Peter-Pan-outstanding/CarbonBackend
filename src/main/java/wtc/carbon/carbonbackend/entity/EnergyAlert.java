package wtc.carbon.carbonbackend.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wtc.carbon.carbonbackend.util.LocalDateTimeDeserializer;
import wtc.carbon.carbonbackend.enums.EnergyStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnergyAlert {
    private Integer id;
    private String monitoringPointName;
    private String monitoringPointAddress;
    private Double realTimePower;
    private Double realTimeVoltage;
    private EnergyStatus status;
    // 应用时间格式。底下两个由数据库的now()生成
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime reportTime;
    private String notes;
    private LocalDateTime  createdAt;
    private LocalDateTime  updatedAt;
}