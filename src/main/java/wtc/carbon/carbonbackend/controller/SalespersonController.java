package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.Salesperson;
import wtc.carbon.carbonbackend.service.SalespersonService;
import java.util.List;

@RestController
@RequestMapping("/salesperson")
public class SalespersonController {

    @Resource
    private SalespersonService salespersonService;

    @GetMapping("/getAllSalespersons")
    public Result<?> getAllSalespersons() {
        List<Salesperson> salespersons = salespersonService.getAllSalespersons();
        if (salespersons.isEmpty()) {
            return Result.error(404, "获取数据失败，请联系管理员");
        } else {
            return Result.success(salespersons);
        }
    }
}
