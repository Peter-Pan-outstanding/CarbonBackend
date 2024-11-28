package wtc.carbon.carbonbackend.service;

import wtc.carbon.carbonbackend.entity.Attachment;

import java.util.List;

public interface AttachmentService {

    // 根据文章id获取当前文章的所有附件
    List<Attachment> getAttachmentsByArticleId(int articleId);

    List<Attachment> getAttachmentsByAnnouncementId(int announcementId);

}
