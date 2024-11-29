package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.SalesPlan;
import wtc.carbon.carbonbackend.service.SalesPlanService;
import java.util.List;

@RestController
@RequestMapping("/salesPlan")
public class SalesPlanController {

    @Resource
    private SalesPlanService salesPlanService;

    @GetMapping("/getAllSalesPlans")
    public Result<?> getAllSalesPlans() {
        List<SalesPlan> salesPlans = salesPlanService.getAllSalesPlans();
        if (salesPlans.isEmpty()) {
            return Result.error(404,"获取数据失败，请联系管理员");
        } else {
            return Result.success(salesPlans);
        }
    }
}
