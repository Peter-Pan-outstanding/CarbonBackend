package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.MonthlyPerformance;
import wtc.carbon.carbonbackend.mapper.MonthlyPerformanceMapper;
import wtc.carbon.carbonbackend.service.MonthlyPerformanceService;

import java.util.List;

@Service
public class MonthlyPerformanceServiceImpl implements MonthlyPerformanceService {

    @Resource
    private MonthlyPerformanceMapper monthlyPerformanceMapper;

    @Override
    public List<MonthlyPerformance> getAllMonthlyPerformances() {
        return monthlyPerformanceMapper.getAllMonthlyPerformances();
    }
}
