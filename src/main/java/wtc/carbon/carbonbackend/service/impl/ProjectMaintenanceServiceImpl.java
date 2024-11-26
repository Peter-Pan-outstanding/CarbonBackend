package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wtc.carbon.carbonbackend.entity.ProjectMaintenance;
import wtc.carbon.carbonbackend.mapper.ProjectMaintenanceMapper;
import wtc.carbon.carbonbackend.service.ProjectMaintenanceService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectMaintenanceServiceImpl implements ProjectMaintenanceService {

    @Resource
    private ProjectMaintenanceMapper projectMaintenanceMapper;

    // 根据ID获取记录
    @Override
    public ProjectMaintenance getProjectById(int id) {
        return projectMaintenanceMapper.getProjectById(id);
    }

    // 获取所有记录
    @Override
    public List<ProjectMaintenance> getAllProjects() {
        return projectMaintenanceMapper.getAllProjects();
    }

    @Override
    public List<ProjectMaintenance> getProjectsByNameAndDate(String projectName,
                                                             LocalDate startDateStart,
                                                             LocalDate startDateEnd,
                                                             LocalDate endDateStart,
                                                             LocalDate endDateEnd,
                                                             Integer status
    ){
        return projectMaintenanceMapper.getProjectsByNameAndDate(projectName, startDateStart, startDateEnd, endDateStart, endDateEnd, status);
    }

    @Override
    public List<ProjectMaintenance> getProjectMaintenanceWithPagination(int pageNumber, int pageSize) {

        int offset = (pageNumber - 1) * pageSize;
        return projectMaintenanceMapper.getProjectMaintenanceWithPagination(pageSize, offset);

    }




    // 添加记录
    @Override
    @Transactional
    public boolean saveProjectMaintenance(ProjectMaintenance project) {
        return projectMaintenanceMapper.saveProjectMaintenance(project) >= 1;
    }






    // 更新记录
    @Override
    @Transactional
    public boolean updateProjectMaintenanceById(ProjectMaintenance project) {
        return projectMaintenanceMapper.updateProjectMaintenance(project) >= 1;
    }




    // 删除记录
    @Override
    @Transactional
    public boolean deleteProjectMaintenanceById(int id) {
        return projectMaintenanceMapper.deleteProjectById(id) >= 1;
    }
}
