package wtc.carbon.carbonbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProcessModeling {
    private Integer processId;                // 主键，自增
    @NotNull
    private String processName;        // 工艺名称
    @NotNull
    private String product;            // 产品
    private String model;              // 型号
    private String specification;      // 规格
    private String unit;               // 单位
    private BigDecimal powerConsumption; // 单位耗电量
    private String remark;             // 备注
    private String processDescription; // 工艺描述
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;   // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;   // 更新时间
}

