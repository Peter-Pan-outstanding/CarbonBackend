package wtc.carbon.carbonbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wtc.carbon.carbonbackend.entity.Attachment;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleWithAttachment {
    private Integer id;                    // 编号，自增主键
    private String title;                  // 标题
    private String documentNumber;         // 文号
    private String issuingDepartment;      // 发布部门
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishDate;         // 发布时间
    private String type;                 // 发布信息（枚举类型）
    private String content;                // 文章内容
    private List<Attachment> attachments; //附件列表
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;           // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;           // 最后更新时间
}
