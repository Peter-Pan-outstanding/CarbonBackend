package wtc.carbon.carbonbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.FactoryModeling;
import wtc.carbon.carbonbackend.entity.ProcessModeling;
import wtc.carbon.carbonbackend.service.ProcessService;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    //查询信息
    private ProcessService processService;
    /**
     * @param pageNumber 显示第几页
     * @param pageSize 一页显示多少行.
     */
    @GetMapping("/getProcessModeling")
    public List<ProcessModeling> getProcessModeling(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String search) {
        return processService.getProcessModeling(pageNumber, pageSize,search);
    }

    // 更新记录
    @PutMapping("/updateProcess")
    public Result<?> updateFactoryById(@RequestBody ProcessModeling alert) {
        boolean isUpdated = processService.updateProcess(alert);
        if (isUpdated) {
            return Result.success("更新成功");
        } else {
            return Result.error(400,"更新失败，请检查id是否存在");
        }
    }

    // 添加记录
    @PostMapping("/saveProcess")
    public Result<?> saveProcess(@RequestBody ProcessModeling alert) {
        boolean isSaved = processService.saveProcess(alert);
        if (isSaved) {
            return Result.success("添加成功");
        } else {
            return Result.error(400,"添加失败");
        }
    }

    // 删除记录
    @DeleteMapping("/deleteProcessById/{id}")
    public Result<?> deleteProcessById(@PathVariable Integer id) {
        boolean isDeleted = processService.deleteProcess(id);
        if (isDeleted) {
            return Result.success("删除成功");
        } else {
            return Result.error(400,"删除失败，请检查id是否存在");
        }
    }
}
