package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.SalesPlan;
import wtc.carbon.carbonbackend.mapper.SalesPlanMapper;
import wtc.carbon.carbonbackend.service.SalesPlanService;

import java.util.List;

@Service
public class SalesPlanServiceImpl implements SalesPlanService {

    @Resource
    private SalesPlanMapper salesPlanMapper;

    @Override
    public List<SalesPlan> getAllSalesPlans() {
        return salesPlanMapper.getAllSalesPlans();
    }
}
