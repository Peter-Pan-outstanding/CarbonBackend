package wtc.carbon.carbonbackend.service;

import wtc.carbon.carbonbackend.entity.AnnouncementTitle;

import java.util.List;

public interface AnnouncementTitleService {

    List<AnnouncementTitle> getAnnouncementTitlesByCategoryWithPagination(Integer category, int pageNumber, int pageSize);
}
