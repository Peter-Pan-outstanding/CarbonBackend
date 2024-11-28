package wtc.carbon.carbonbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wtc.carbon.carbonbackend.entity.Attachment;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementDetailWithAttachment {
    private Integer id;                         // 编号，自增主键
    private String title;                       // 冗余字段：公告标题
    private String projectNumber;               // 项目编号
    private String tenderUnit;                  // 招标单位
    private String content;                     // 公告内容
    private List<Attachment> attachments;       // 附件列表
    @JsonIgnore
    private Timestamp createdAt;                // 创建时间
    @JsonIgnore
    private Timestamp updatedAt;                // 最后更新时间
}
