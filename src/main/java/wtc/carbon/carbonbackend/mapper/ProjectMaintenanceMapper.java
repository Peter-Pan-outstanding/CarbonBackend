package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import wtc.carbon.carbonbackend.entity.ProjectMaintenance;

import java.util.List;

@Mapper
public interface ProjectMaintenanceMapper {

    // 根据 ID 查询记录
    ProjectMaintenance getProjectById(Integer id);

    // 查询所有记录
    List<ProjectMaintenance> getAllProjects();



    // 插入新记录
    int saveProjectMaintenance(ProjectMaintenance project);



    // 更新表(如果是null就不更新)
    int updateProjectMaintenance(ProjectMaintenance project);




    // 删除记录
    int deleteProjectById(Integer id);
}
