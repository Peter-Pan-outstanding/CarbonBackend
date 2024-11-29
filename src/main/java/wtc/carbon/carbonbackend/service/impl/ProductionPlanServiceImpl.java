package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.ProductionPlan;
import wtc.carbon.carbonbackend.mapper.ProductionPlanMapper;
import wtc.carbon.carbonbackend.service.ProductionPlanService;

import java.util.List;

@Service
public class ProductionPlanServiceImpl implements ProductionPlanService {

    @Resource
    private ProductionPlanMapper productionPlanMapper;

    @Override
    public List<ProductionPlan> getAllProductionPlans() {
        return productionPlanMapper.getAllProductionPlans();
    }
}
