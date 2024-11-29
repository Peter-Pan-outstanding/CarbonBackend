package wtc.carbon.carbonbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Equipment {
    private Integer equipmentId;                // 主键，自增
    @NotNull
    private String equipmentCode;      // 设备编码
    @NotNull
    private String equipmentName;      // 设备名称
    private String equipmentModel;     // 设备型号
    private String equipmentSpec;      // 设备规格
    private String manufacturer;       // 制造商
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate productionDate; // 生产日期
    private String productionBatch;    // 生产批号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;   // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;   // 更新时间
}
