package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.Attachment;
import wtc.carbon.carbonbackend.mapper.AttachmentMapper;
import wtc.carbon.carbonbackend.service.AttachmentService;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Resource
    private AttachmentMapper attachmentMapper;

    @Override
    public List<Attachment> getAttachmentsByArticleId(int articleId) {
        return attachmentMapper.getAttachmentsByArticleId(articleId);
    }

    @Override
    public List<Attachment> getAttachmentsByAnnouncementId(int announcementId) {
        return attachmentMapper.getAttachmentsByAnnouncementId(announcementId);
    }
}
