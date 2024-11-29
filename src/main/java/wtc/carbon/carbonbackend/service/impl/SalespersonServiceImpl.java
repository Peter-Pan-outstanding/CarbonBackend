package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.Salesperson;
import wtc.carbon.carbonbackend.mapper.SalespersonMapper;
import wtc.carbon.carbonbackend.service.SalespersonService;

import java.util.List;

@Service
public class SalespersonServiceImpl implements SalespersonService {

    @Resource
    private SalespersonMapper salespersonMapper;

    @Override
    public List<Salesperson> getAllSalespersons() {
        return salespersonMapper.getAllSalespersons();
    }
}
