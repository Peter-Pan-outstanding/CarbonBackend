package wtc.carbon.carbonbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.sql.Timestamp;

@Data
public class AnnouncementDetail {
    private Integer id;                         // 编号，自增主键
    private String title;                       // 冗余字段：公告标题
    private String projectNumber;               // 项目编号
    private String tenderUnit;                  // 招标单位
    private String content;                     // 公告内容
    @JsonIgnore
    private Timestamp createdAt;                // 创建时间
    @JsonIgnore
    private Timestamp updatedAt;                // 最后更新时间
}