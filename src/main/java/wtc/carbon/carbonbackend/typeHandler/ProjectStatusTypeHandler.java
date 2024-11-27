package wtc.carbon.carbonbackend.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import wtc.carbon.carbonbackend.enums.ProjectStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectStatusTypeHandler extends BaseTypeHandler<ProjectStatus> {

    // 设置参数
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ProjectStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());  // 将枚举的值设置到 PreparedStatement 中
    }

    // 获取列值
    @Override
    public ProjectStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);  // 获取列的 int 值
        return ProjectStatus.fromValue(value);  // 将值转换成 ProjectStatus 枚举
    }

    @Override
    public ProjectStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);  // 获取列的 int 值
        return ProjectStatus.fromValue(value);  // 将值转换成 ProjectStatus 枚举
    }

    @Override
    public ProjectStatus getNullableResult(java.sql.CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);  // 获取列的 int 值
        return ProjectStatus.fromValue(value);  // 将值转换成 ProjectStatus 枚举
    }
}
