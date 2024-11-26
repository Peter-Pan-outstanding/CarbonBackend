package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.ProjectMaintenance;
import wtc.carbon.carbonbackend.service.ProjectMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/projectMaintenance")
public class ProjectMaintenanceController {

    @Resource
    private ProjectMaintenanceService projectMaintenanceService;

    // 根据 ID 查询
    @GetMapping("/getProjectById/{id}")
    public Result<ProjectMaintenance> getProjectById(@PathVariable Integer id) {
        ProjectMaintenance project = projectMaintenanceService.getProjectById(id);
        if (project != null) {
            return Result.success(project);
        } else {
            return Result.error(404, "ID 没有找到");
        }
    }

    // 查询所有记录
    @GetMapping("/getAllProjects")
    public Result<List<ProjectMaintenance>> getAllProjects() {
        List<ProjectMaintenance> projects = projectMaintenanceService.getAllProjects();
        return Result.success(projects);
    }

    // 添加记录
    @PostMapping("/saveProject")
    public Result<?> saveProject(@RequestBody ProjectMaintenance project) {
        boolean isAdded = projectMaintenanceService.saveProjectMaintenance(project);
        if (isAdded) {
            return Result.success("新增成功");
        } else {
            return Result.error(400, "新增失败");
        }
    }

    // 更新记录
    @PutMapping("/updateProjectById")
    public Result<?> updateProjectById(@RequestBody ProjectMaintenance project) {
        boolean isUpdated = projectMaintenanceService.updateProjectMaintenanceById(project);
        if (isUpdated) {
            return Result.success("更新成功");
        } else {
            return Result.error(400, "更新失败，请检查ID是否存在");
        }
    }

    // 删除记录
    @DeleteMapping("/deleteProjectById/{id}")
    public Result<?> deleteProjectById(@PathVariable Integer id) {
        boolean isDeleted = projectMaintenanceService.deleteProjectMaintenanceById(id);
        if (isDeleted) {
            return Result.success("删除成功");
        } else {
            return Result.error(400, "删除失败，请检查ID是否存在");
        }
    }
}
