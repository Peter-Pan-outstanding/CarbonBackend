package wtc.carbon.carbonbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FactoryModeling {
    private Integer FactoryId;                // 主键，自增
    @NotNull
    private String productionLine;     // 生产线名称
    @NotNull
    private String product;            // 产品
    private String productModel;       // 产品型号（不可编辑）
    private String productSpecification; // 产品规格（不可编辑）
    private String description;        // 描述
    private Integer materialId;        // 物料档案ID（逻辑外键）
    private Integer equipmentId;       // 设备ID（逻辑外键）
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;   // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;   // 更新时间
}

