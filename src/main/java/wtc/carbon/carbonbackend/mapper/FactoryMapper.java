package wtc.carbon.carbonbackend.mapper;


import org.apache.ibatis.annotations.Mapper;
import wtc.carbon.carbonbackend.entity.Equipment;
import wtc.carbon.carbonbackend.entity.FactoryModeling;
import wtc.carbon.carbonbackend.entity.Material;

import java.util.List;

@Mapper
public interface FactoryMapper {
    List<FactoryModeling> list();

    int updateFactory(FactoryModeling alert);

    List<Material> getMaterialList(String materialType);

    List<Equipment> getEquipmentList(Integer factoryId);

    int insertEquipment(Equipment alert);

    int deleteFactory(Integer id);

    int deleteEquipment(Integer id);

    List<FactoryModeling> getFactoryModelingWithPagination(int limit, int offset, String search);

    int insertFactory(FactoryModeling alert);
}
