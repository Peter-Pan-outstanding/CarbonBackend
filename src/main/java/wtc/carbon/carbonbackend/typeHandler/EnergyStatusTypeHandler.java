package wtc.carbon.carbonbackend.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import wtc.carbon.carbonbackend.enums.EnergyStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnergyStatusTypeHandler extends BaseTypeHandler<EnergyStatus> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, EnergyStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public EnergyStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        return EnergyStatus.fromValue(value);
    }

    @Override
    public EnergyStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        return EnergyStatus.fromValue(value);
    }

    @Override
    public EnergyStatus getNullableResult(java.sql.CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        return EnergyStatus.fromValue(value);
    }
}
