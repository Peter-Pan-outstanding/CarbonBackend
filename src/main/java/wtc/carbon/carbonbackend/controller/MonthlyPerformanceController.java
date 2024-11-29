package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.MonthlyPerformance;
import wtc.carbon.carbonbackend.service.MonthlyPerformanceService;
import java.util.List;

@RestController
@RequestMapping("/monthlyPerformance")
public class MonthlyPerformanceController {

    @Resource
    private MonthlyPerformanceService monthlyPerformanceService;

    @GetMapping("/getAllMonthlyPerformances")
    public Result<?> getAllMonthlyPerformances() {
        List<MonthlyPerformance> monthlyPerformances = monthlyPerformanceService.getAllMonthlyPerformances();
        if (monthlyPerformances.isEmpty()) {
            return Result.error(404,"获取数据失败，请联系管理员");
        }else {
            return Result.success(monthlyPerformances);
        }
    }
}
