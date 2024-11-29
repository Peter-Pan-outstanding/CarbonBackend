package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import wtc.carbon.carbonbackend.entity.AnnouncementTitle;

import java.util.List;

@Mapper
public interface AnnouncementTitleMapper {

    // 通过类别返回数据
    List<AnnouncementTitle> getAnnouncementTitlesByCategoryWithPagination(String category, int limit, int offset);

}
