package wtc.carbon.carbonbackend.service;

import wtc.carbon.carbonbackend.entity.ProjectMaintenance;

import java.util.List;

public interface ProjectMaintenanceService {

    ProjectMaintenance getProjectById(int id);

    List<ProjectMaintenance> getAllProjects();

    boolean saveProjectMaintenance(ProjectMaintenance projectMaintenance);

    boolean updateProjectMaintenanceById(ProjectMaintenance projectMaintenance);

    boolean deleteProjectMaintenanceById(int id);
}

