package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.EnergyAlert;
import wtc.carbon.carbonbackend.enums.EnergyStatus;
import wtc.carbon.carbonbackend.service.EnergyAlertService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/energyAlerts")
public class EnergyAlertController {

    @Resource
    private EnergyAlertService energyAlertService;

    // 根据 ID 查询
    @GetMapping("/getEnergyAlertById/{id}")
    public Result<EnergyAlert> getEnergyAlertById(@PathVariable Integer id) {
        EnergyAlert energyAlert = energyAlertService.getEnergyAlertById(id);
        if (energyAlert != null) {
            return Result.success(energyAlert);
        } else {
            return Result.error(404,"id 没有找到");
        }
    }

    // 查询所有记录
    @GetMapping("/getAllEnergyAlerts")
    public Result<List<EnergyAlert>> getAllEnergyAlerts() {
        List<EnergyAlert> energyAlerts = energyAlertService.getAllEnergyAlerts();
        return Result.success(energyAlerts);
    }

    // 根据条件查询
    @GetMapping("/getEnergyAlertsByConditions")
    public Result<List<EnergyAlert>> getEnergyAlertsByConditions(
            @RequestParam(required = false) String monitoringPointName,
            @RequestParam(required = false) String monitoringPointAddress,
            @RequestParam(required = false) Integer status
            ){
        List<EnergyAlert> energyAlerts = energyAlertService.getEnergyAlertsByConditions(monitoringPointName, monitoringPointAddress, status);

        return Result.success(energyAlerts);
    }

    /**
     * @param pageNumber 显示第几页
     * @param pageSize 一页显示多少行.
     */
    @GetMapping("/getEnergyAlertsWithPagination")
    public Result<HashMap<String,Object>> getEnergyAlertsWithPagination(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        HashMap<String, Object> alerts = energyAlertService.getEnergyAlertsWithPagination(pageNumber, pageSize);
        if (alerts != null) {
            return Result.success(alerts);
        }else {
            return Result.error(400,"获取分页数据失败");
        }
    }



    // 添加记录
    @PostMapping("/saveEnergyAlert")
    public Result<?> saveEnergyAlert(@RequestBody EnergyAlert alert) {
        boolean isAdded = energyAlertService.addEnergyAlert(alert);
        if (isAdded) {
            return Result.success("新增成功");
        } else {
            return Result.error(400,"新增失败");
        }
    }



    // 更新记录
    @PutMapping("/updateEnergyAlertById")
    public Result<?> updateEnergyAlertById(@RequestBody EnergyAlert alert) {
        boolean isUpdated = energyAlertService.updateEnergyAlert(alert);
        if (isUpdated) {
            return Result.success("更新成功");
        } else {
            return Result.error(400,"更新失败，请检查id是否存在");
        }
    }


    // 删除记录
    @DeleteMapping("/deleteEnergyAlertById/{id}")
    public Result<?> deleteEnergyAlertById(@PathVariable Integer id) {
        boolean isDeleted = energyAlertService.deleteEnergyAlert(id);
        if (isDeleted) {
            return Result.success("删除成功");
        } else {
            return Result.error(400,"删除失败，请检查id是否存在");
        }
    }
}