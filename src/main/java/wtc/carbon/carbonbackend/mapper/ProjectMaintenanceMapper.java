package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import wtc.carbon.carbonbackend.entity.ProjectMaintenance;

import java.util.List;

@Mapper
public interface ProjectMaintenanceMapper {

    // 根据 ID 查询记录
    @Select("SELECT * FROM a_project_maintenance WHERE id = #{id}")
    ProjectMaintenance getProjectById(Integer id);

    // 查询所有记录
    @Select("SELECT * FROM a_project_maintenance")
    List<ProjectMaintenance> getAllProjects();



    // 插入新记录
    @Insert("INSERT INTO a_project_maintenance (project_name, manager, start_date, end_date, status, created_at, updated_at) " +
            "VALUES (#{projectName}, #{manager}, #{startDate}, #{endDate}, #{status}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveProjectMaintenance(ProjectMaintenance project);



    // 更新表(如果是null就不更新)
    @UpdateProvider(type = ProjectMaintenanceSqlProvider.class, method = "updateProjectMaintenanceSql")
    int updateProjectMaintenance(ProjectMaintenance project);

    // 动态更新
    class ProjectMaintenanceSqlProvider {
        public String updateProjectMaintenanceSql(final ProjectMaintenance project) {
            return new SQL() {{
                UPDATE("a_project_maintenance");

                if (project.getProjectName() != null) {
                    SET("project_name = #{projectName}");
                }
                if (project.getManager() != null) {
                    SET("manager = #{manager}");
                }
                if (project.getStartDate() != null) {
                    SET("start_date = #{startDate}");
                }
                if (project.getEndDate() != null) {
                    SET("end_date = #{endDate}");
                }
                if (project.getStatus() != null) {
                    SET("status = #{status}");
                }
                SET("updated_at = CURRENT_TIMESTAMP");

                WHERE("id = #{id}");
            }}.toString();
        }
    }



    // 删除记录
    @Delete("DELETE FROM a_project_maintenance WHERE id = #{id}")
    int deleteProjectById(Integer id);
}
