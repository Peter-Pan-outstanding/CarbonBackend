package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.EnergyData;
import wtc.carbon.carbonbackend.service.EnergyDataService;

import java.util.List;

@RestController
@RequestMapping("/energyData")
public class EnergyDataController {

    @Resource
    private EnergyDataService energyDataService;

    @GetMapping("/getOverviewData")
    public Result<?> getOverviewData(){
        List<EnergyData> overviewData = energyDataService.getOverviewData();
        if (!overviewData.isEmpty()) {
            return Result.success(overviewData);
        } else {
            return Result.error(404, "获取能耗总览失败，请联系管理员");
        }
    }

    @GetMapping("/getUsageData")
    public Result<?> getUsageData(){
        List<EnergyData> usageData = energyDataService.getUsageData();
        if (!usageData.isEmpty()) {
            return Result.success(usageData);
        } else {
            return Result.error(404, "获取办公与生产耗能失败，请联系管理员");
        }
    }
}
