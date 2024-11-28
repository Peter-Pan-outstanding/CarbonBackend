package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.AnnouncementTitle;
import wtc.carbon.carbonbackend.mapper.AnnouncementTitleMapper;
import wtc.carbon.carbonbackend.service.AnnouncementTitleService;

import java.util.List;

@Service
public class AnnouncementTitleServiceImpl implements AnnouncementTitleService {

    @Resource
    private AnnouncementTitleMapper announcementTitleMapper;



    @Override
    public List<AnnouncementTitle> getAnnouncementTitlesByCategoryWithPagination(Integer category, int pageNumber, int pageSize) {
        String strCategory;

        // 类别较少，直接在Java里判断
        if (category == 0) {
            strCategory = "招标公告";
        } else if (category == 1) {
            strCategory = "中标公告";
        } else if (category == 2) {
            strCategory = "采购公告";
        } else {
            return null;
        }

        int offset = (pageNumber - 1) * pageSize;

        return announcementTitleMapper.getAnnouncementTitlesByCategoryWithPagination(strCategory,pageSize, offset);
    }
}
