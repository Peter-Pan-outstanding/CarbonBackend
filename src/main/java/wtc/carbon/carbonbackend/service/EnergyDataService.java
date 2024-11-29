package wtc.carbon.carbonbackend.service;

import wtc.carbon.carbonbackend.entity.EnergyData;
import java.util.List;

public interface EnergyDataService {
    // 左上的数据
    List<EnergyData> getOverviewData();

    // 左中的数据
    List<EnergyData> getUsageData();
}
