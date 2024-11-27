package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.ProjectMaintenance;
import wtc.carbon.carbonbackend.service.ProjectMaintenanceService;

import java.time.LocalDate;
import java.util.HashMap;
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

    /**
     * 数据库里有两个日期字段 start_date 和 end_date
     * 查询条件是 startDateStart <= start_date <= startDateEnd
     *          endDateStart <= end_date <= endDateEnd
     */
    @GetMapping("/getProjectsByNameAndDate")
    public Result<List<ProjectMaintenance>> getProjectsByNameAndDate(
            @RequestParam(required = false) String projectName,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-M-d") LocalDate startDateStart,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-M-d")LocalDate startDateEnd,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-M-d")LocalDate endDateStart,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-M-d")LocalDate endDateEnd,
            @RequestParam(required = false) Integer status
            ) {
        List<ProjectMaintenance> projects = projectMaintenanceService.getProjectsByNameAndDate(projectName,
                startDateStart,
                startDateEnd,
                endDateStart,
                endDateEnd,
                status);
        if (projects != null) {
            return Result.success(projects);
        }else {
            return Result.error(400,"请输入正确的名称或者时间");
        }
    }

    // 分页查询
    @GetMapping ("/getProjectMaintenanceWithPagination")
    public Result<HashMap<String,Object>> getProjectMaintenanceWithPagination(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        HashMap<String, Object> map = projectMaintenanceService.getProjectMaintenanceWithPagination(pageNumber, pageSize);
        if (map != null) {
            return Result.success(map);
        }else {
            return Result.error(400,"页数有误");
        }
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
