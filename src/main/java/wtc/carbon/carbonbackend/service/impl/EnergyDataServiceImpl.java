package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import wtc.carbon.carbonbackend.entity.EnergyData;
import wtc.carbon.carbonbackend.mapper.EnergyDataMapper;
import wtc.carbon.carbonbackend.service.EnergyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnergyDataServiceImpl implements EnergyDataService {

    @Resource
    private EnergyDataMapper energyDataMapper;

    @Override
    public List<EnergyData> getOverviewData() {
        // 字符串 "overview" 直接写死在方法中
        return energyDataMapper.getEnergyDataByCategory("overview");
    }

    @Override
    public List<EnergyData> getUsageData() {
        // 字符串 "usage" 直接写死在方法中
        return energyDataMapper.getEnergyDataByCategory("usage");
    }
}
