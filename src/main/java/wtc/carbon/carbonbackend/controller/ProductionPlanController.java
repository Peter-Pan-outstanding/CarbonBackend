package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.ProductionPlan;
import wtc.carbon.carbonbackend.service.ProductionPlanService;
import java.util.List;

@RestController
@RequestMapping("/productionPlan")
public class ProductionPlanController {

    @Resource
    private ProductionPlanService productionPlanService;

    @GetMapping("/getAllProductionPlans")
    public Result<?> getAllProductionPlans() {
        List<ProductionPlan> productionPlans = productionPlanService.getAllProductionPlans();
        if (productionPlans.isEmpty()) {
            return Result.error(404, "获取数据失败，请联系管理员");
        } else {
            return Result.success(productionPlans);
        }
    }
}
