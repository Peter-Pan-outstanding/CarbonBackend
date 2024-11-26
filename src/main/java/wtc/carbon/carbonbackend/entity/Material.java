package wtc.carbon.carbonbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Material {
    private Integer MaterialId;                // 主键，自增
    @NotNull
    private String materialCode;       // 物料编码
    @NotNull
    private String materialName;       // 物料名称
    private String materialModel;      // 物料型号
    private String materialSpec;       // 物料规格
    private String materialUnit;       // 物料单位
    private BigDecimal materialPrice;  // 物料单价
    private String materialType;       // 物料类型
    private String materialRemark;     // 物料备注
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;       // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;       // 更新时间
}
