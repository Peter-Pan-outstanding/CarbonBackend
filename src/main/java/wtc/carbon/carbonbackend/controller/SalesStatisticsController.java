package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.SalesStatistics;
import wtc.carbon.carbonbackend.service.SalesStatisticsService;
import java.util.List;

@RestController
@RequestMapping("/salesStatistics")
public class SalesStatisticsController {

    @Resource
    private SalesStatisticsService salesStatisticsService;

    @GetMapping("/getAllSalesStatistics")
    public Result<?> getAllSalesStatistics() {
        List<SalesStatistics> salesStatistics = salesStatisticsService.getAllSalesStatistics();
        if (salesStatistics.isEmpty()) {
            return Result.error(404, "获取数据失败，请联系管理员");
        } else {
            return Result.success(salesStatistics);
        }
    }
}
