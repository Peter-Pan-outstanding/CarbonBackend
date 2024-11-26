package wtc.carbon.carbonbackend.service;

import wtc.carbon.carbonbackend.entity.Equipment;
import wtc.carbon.carbonbackend.entity.FactoryModeling;
import wtc.carbon.carbonbackend.entity.Material;

import java.util.List;


public interface FactoryService {
    // 查询所有记录
    List<FactoryModeling> list();

    // 更新记录
    boolean updateFactory(FactoryModeling alert);

    List<Material> getMaterialList(String materialType);

    List<Equipment> getEquipmentList(Integer factoryId);

    boolean addEquipment(Equipment alert);

    boolean deleteFactory(Integer id);

    boolean deleteEquipment(Integer id);

    List<FactoryModeling> getFactoryModelingWithPagination(int pageNumber, int pageSize,String search);

    boolean addFactory(FactoryModeling alert);
}
