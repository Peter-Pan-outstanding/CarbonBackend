package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.SalesStatistics;
import wtc.carbon.carbonbackend.mapper.SalesStatisticsMapper;
import wtc.carbon.carbonbackend.service.SalesStatisticsService;

import java.util.List;

@Service
public class SalesStatisticsServiceImpl implements SalesStatisticsService {

    @Resource
    private SalesStatisticsMapper salesStatisticsMapper;

    @Override
    public List<SalesStatistics> getAllSalesStatistics() {
        return salesStatisticsMapper.getAllSalesStatistics();
    }
}
