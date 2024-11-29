package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import wtc.carbon.carbonbackend.entity.AnnouncementDetail;

@Mapper
public interface AnnouncementDetailMapper {

    AnnouncementDetail getAnnouncementDetailById(int id);

}
