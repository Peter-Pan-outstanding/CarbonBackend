package wtc.carbon.carbonbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wtc.carbon.carbonbackend.enums.EnergyStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnergyAlert {
    private Integer id;
    private String monitoringPointName; // 检测点名称
    private String monitoringPointAddress;
    private Double realTimePower;
    private Double realTimeVoltage;
    private EnergyStatus status;
    // 应用时间格式。底下两个由数据库的now()生成
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reportTime;
    private String notes;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime  createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime  updatedAt;
}