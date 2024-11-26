package wtc.carbon.carbonbackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.Equipment;
import wtc.carbon.carbonbackend.entity.FactoryModeling;
import wtc.carbon.carbonbackend.entity.Material;
import wtc.carbon.carbonbackend.service.FactoryService;

import java.util.List;

@RestController
@RequestMapping("/factory")
public class FactoryController {

    @Autowired
    private FactoryService factoryService;

    //查询所有工厂信息
    @GetMapping
    public Result<List<FactoryModeling>> list(){
        List<FactoryModeling> fm = factoryService.list();
        return Result.success(fm);
    }

    /**
     * @param pageNumber 显示第几页
     * @param pageSize 一页显示多少行.
     */
    @GetMapping("/getFactoryModeling")
    public List<FactoryModeling> getFactoryModelingWithPagination(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String search) {
        return factoryService.getFactoryModelingWithPagination(pageNumber, pageSize,search);
    }

    //查询物料信息
    @GetMapping("/material")
    public Result<List<Material>> getMaterialList(String materialType){
        List<Material> m = factoryService.getMaterialList(materialType);
        return Result.success(m);
    }

    //以工厂id查询产品建模明细信息
    @GetMapping("/equipment")
    public Result<List<Equipment>> getEquipmentList(Integer factoryId){
        List<Equipment> e = factoryService.getEquipmentList(factoryId);
        return Result.success(e);
    }

    //添加工厂建模明细信息
    @PostMapping("/saveFactory")
    public Result<?> saveFactory(@RequestBody FactoryModeling alert) {
        boolean isAdded = factoryService.addFactory(alert);
        if (isAdded) {
            return Result.success("新增成功");
        } else {
            return Result.error(400,"新增失败");
        }
    }

    //添加产品建模明细信息
    @PostMapping("/saveEquipment")
    public Result<?> saveEquipment(@RequestBody Equipment alert) {
        boolean isAdded = factoryService.addEquipment(alert);
        if (isAdded) {
            return Result.success("新增成功");
        } else {
            return Result.error(400,"新增失败");
        }
    }

    // 更新记录
    @PutMapping("/updateFactory")
    public Result<?> updateFactoryById(@RequestBody FactoryModeling alert) {
        boolean isUpdated = factoryService.updateFactory(alert);
        if (isUpdated) {
            return Result.success("更新成功");
        } else {
            return Result.error(400,"更新失败，请检查id是否存在");
        }
    }

    //按id删除工厂建模数据
    @DeleteMapping("/deleteFactoryById/{id}")
    public Result<?> deleteFactoryById(@PathVariable Integer id) {
        boolean isDeleted = factoryService.deleteFactory(id);
        if (isDeleted) {
            return Result.success("删除成功");
        } else {
            return Result.error(400,"删除失败，请检查id是否存在");
        }
    }

    //按id删除产品建模信息
    @DeleteMapping("/deleteEquipmentById/{id}")
    public Result<?> deleteEquipmentById(@PathVariable Integer id) {
        boolean isDeleted = factoryService.deleteEquipment(id);
        if (isDeleted) {
            return Result.success("删除成功");
        } else {
            return Result.error(400,"删除失败，请检查id是否存在");
        }
    }
}
