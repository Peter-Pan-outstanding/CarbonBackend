package wtc.carbon.carbonbackend.mapper;


import org.apache.ibatis.annotations.Mapper;
import wtc.carbon.carbonbackend.entity.FactoryModeling;

import java.util.List;

@Mapper
public interface FactoryMapper {
    List<FactoryModeling> list();
}
