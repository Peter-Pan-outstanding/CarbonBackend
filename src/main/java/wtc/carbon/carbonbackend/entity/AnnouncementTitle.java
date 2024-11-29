package wtc.carbon.carbonbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.sql.Timestamp;

@Data
public class AnnouncementTitle {
    private Integer id;                         // 编号，自增主键
    private String title;                       // 公告标题
    private Integer announcementDetailId;       // 与内容表关联，一个标题只能对应一个内容
    private String publishingUnit;              // 发布单位
    private Timestamp publishDate;              // 发布时间
    private Double projectAmount;               // 项目金额
    private String status;                      // 状态 ("进行中", "已结束")
    private String category;                    // 类别 ("招标公告", "中标公告", "采购公告")
    @JsonIgnore
    private Timestamp createdAt;                // 创建时间
    @JsonIgnore
    private Timestamp updatedAt;                // 最后更新时间
}
