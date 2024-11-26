package wtc.carbon.carbonbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.Equipment;
import wtc.carbon.carbonbackend.entity.Material;
import wtc.carbon.carbonbackend.mapper.FactoryMapper;
import wtc.carbon.carbonbackend.service.FactoryService;
import wtc.carbon.carbonbackend.entity.FactoryModeling;

import java.util.List;

@Service
public class FactoryServiceImpl implements FactoryService {
    @Autowired
    private FactoryMapper factoryMapper;

    @Override
    public List<FactoryModeling> list() {
        return factoryMapper.list();
    }

    @Override
    public List<Material> getMaterialList(String materialType) {
        return factoryMapper.getMaterialList(materialType);
    }

    @Override
    public List<Equipment> getEquipmentList(Integer factoryId) {
        return factoryMapper.getEquipmentList(factoryId);
    }

    @Override
    public boolean addEquipment(Equipment alert) {
        return factoryMapper.insertEquipment(alert) >= 1;
    }

    @Override
    public boolean deleteFactory(Integer id) {
        return factoryMapper.deleteFactory(id) >= 1;
    }

    @Override
    public boolean deleteEquipment(Integer id) {
        return factoryMapper.deleteEquipment(id) >= 1;
    }

    @Override
    public List<FactoryModeling> getFactoryModelingWithPagination(int pageNumber, int pageSize,String search) {
        int offset = (pageNumber - 1) * pageSize;
        return factoryMapper.getFactoryModelingWithPagination(pageSize, offset, search);
    }

    @Override
    public boolean addFactory(FactoryModeling alert) {
        return factoryMapper.insertFactory(alert) >= 1;
    }

    @Override
    public boolean updateFactory(FactoryModeling alert) {
        return factoryMapper.updateFactory(alert) >= 1;
    }


}
