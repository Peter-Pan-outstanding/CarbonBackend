package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Select;
import wtc.carbon.carbonbackend.entity.EnergyData;
import java.util.List;

public interface EnergyDataMapper {
    @Select("SELECT * FROM a_energy_data WHERE `data_category` = #{dataCategory}")
    List<EnergyData> getEnergyDataByCategory(String dataCategory);
}
