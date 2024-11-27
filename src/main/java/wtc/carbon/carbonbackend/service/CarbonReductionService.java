package wtc.carbon.carbonbackend.service;

import java.util.HashMap;
import java.util.Map;

public interface CarbonReductionService {

    // 获取上半部分的数据
    // 项目总数，总投资额，减少的碳排放，能约节约的比例
    HashMap<String, Number> getProjectData();

    // 获取碳排放趋势
    Map<String, Double> getCarbonTendency();

}
