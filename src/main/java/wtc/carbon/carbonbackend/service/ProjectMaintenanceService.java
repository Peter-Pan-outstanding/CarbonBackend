package wtc.carbon.carbonbackend.service;

import wtc.carbon.carbonbackend.entity.ProjectMaintenance;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface ProjectMaintenanceService {

    ProjectMaintenance getProjectById(int id);

    List<ProjectMaintenance> getAllProjects();

    List<ProjectMaintenance> getProjectsByNameAndDate(String projectName,
                                                      LocalDate startDateStart,
                                                      LocalDate startDateEnd,
                                                      LocalDate endDateStart,
                                                      LocalDate endDateEnd,
                                                      Integer status
                                                      );

    HashMap<String, Object> getProjectMaintenanceWithPagination(int pageNumber, int pageSize);


    boolean saveProjectMaintenance(ProjectMaintenance projectMaintenance);

    boolean updateProjectMaintenanceById(ProjectMaintenance projectMaintenance);

    boolean deleteProjectMaintenanceById(int id);
}

