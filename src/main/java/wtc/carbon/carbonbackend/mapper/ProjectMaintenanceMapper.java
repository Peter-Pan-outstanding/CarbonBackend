package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import wtc.carbon.carbonbackend.entity.ProjectMaintenance;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ProjectMaintenanceMapper {

    // 根据 ID 查询记录
    ProjectMaintenance getProjectById(Integer id);

    // 查询所有记录
    List<ProjectMaintenance> getAllProjects();

    // 根据名称和时间查询
    List<ProjectMaintenance> getProjectsByNameAndDate(
            String projectName,
            LocalDate startDateStart,
            LocalDate startDateEnd,
            LocalDate endDateStart,
            LocalDate endDateEnd,
            Integer status
    );

    // 分页查询
    List<ProjectMaintenance> getProjectMaintenanceWithPagination(int limit, int offset);

    // 获取总数
    int getProjectMaintenanceCount();



    // 插入新记录
    int saveProjectMaintenance(ProjectMaintenance project);



    // 更新表(如果是null就不更新)
    int updateProjectMaintenance(ProjectMaintenance project);




    // 删除记录
    int deleteProjectById(Integer id);
}
