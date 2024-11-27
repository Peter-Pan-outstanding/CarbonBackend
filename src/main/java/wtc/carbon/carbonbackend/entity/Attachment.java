package wtc.carbon.carbonbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Attachment {
    private Integer id;                    // 编号，自增主键
    private String fileUrl;                // 附件地址
    private String name;
    private String size;
    private Integer articleId;             // 文章编号（与文章表关联）
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;           // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;           // 最后更新时间
}
