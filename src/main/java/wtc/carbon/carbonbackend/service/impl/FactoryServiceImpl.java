package wtc.carbon.carbonbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
