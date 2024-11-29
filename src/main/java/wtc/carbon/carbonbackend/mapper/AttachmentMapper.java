package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import wtc.carbon.carbonbackend.entity.Attachment;

import java.util.List;

@Mapper
public interface AttachmentMapper {
    List<Attachment> getAttachmentsByArticleId(int articleId);

    List<Attachment> getAttachmentsByAnnouncementId(int announcementId);
}
