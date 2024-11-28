package wtc.carbon.carbonbackend.service;

import wtc.carbon.carbonbackend.dto.AnnouncementDetailWithAttachment;
import wtc.carbon.carbonbackend.entity.AnnouncementDetail;

public interface AnnouncementDetailService {

    AnnouncementDetailWithAttachment getAnnouncementDetailById(int id);
}
