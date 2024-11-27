package wtc.carbon.carbonbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Article {
    private Integer id;                    // 编号，自增主键
    private String title;                  // 标题
    private String documentNumber;         // 文号
    private String issuingDepartment;      // 发布部门
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishDate;         // 发布时间
    private String type;                 // 发布信息（枚举类型）
    private String content;                // 文章内容
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;           // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;           // 最后更新时间
}
