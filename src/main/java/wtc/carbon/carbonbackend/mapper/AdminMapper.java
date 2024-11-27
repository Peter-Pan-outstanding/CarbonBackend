package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import wtc.carbon.carbonbackend.entity.Admin;

@Mapper
public interface AdminMapper {

    Admin getAdminByUsername(String username);
}
