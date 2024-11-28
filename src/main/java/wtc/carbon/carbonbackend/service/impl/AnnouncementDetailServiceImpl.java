package wtc.carbon.carbonbackend.service.impl;

import wtc.carbon.carbonbackend.dto.AnnouncementDetailWithAttachment;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.AnnouncementDetail;
import wtc.carbon.carbonbackend.entity.Attachment;
import wtc.carbon.carbonbackend.mapper.AnnouncementDetailMapper;
import wtc.carbon.carbonbackend.mapper.AttachmentMapper;
import wtc.carbon.carbonbackend.service.AnnouncementDetailService;

import java.util.List;

@Service
public class AnnouncementDetailServiceImpl implements AnnouncementDetailService {

    @Resource
    private AnnouncementDetailMapper announcementDetailMapper;

    @Resource
    private AttachmentMapper attachmentMapper;


    private AnnouncementDetailWithAttachment toAnnouncementDetailWithAttachment(AnnouncementDetail announcementDetail, List<Attachment> attachments) {
        return new AnnouncementDetailWithAttachment(
                announcementDetail.getId(),
                announcementDetail.getTitle(),
                announcementDetail.getProjectNumber(),
                announcementDetail.getTenderUnit(),
                announcementDetail.getContent(),
                attachments,
                announcementDetail.getCreatedAt(),
                announcementDetail.getUpdatedAt()
        );
    }


    @Override
    public AnnouncementDetailWithAttachment getAnnouncementDetailById(int id) {
        AnnouncementDetail announcementDetail = announcementDetailMapper.getAnnouncementDetailById(id);

        List<Attachment> attachments = attachmentMapper.getAttachmentsByAnnouncementId(id);

        return new AnnouncementDetailWithAttachment(
                announcementDetail.getId(),
                announcementDetail.getTitle(),
                announcementDetail.getProjectNumber(),
                announcementDetail.getTenderUnit(),
                announcementDetail.getContent(),
                attachments,
                announcementDetail.getCreatedAt(),
                announcementDetail.getUpdatedAt()
        );
    }

}
