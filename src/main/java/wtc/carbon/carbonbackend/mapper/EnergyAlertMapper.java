package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import wtc.carbon.carbonbackend.entity.EnergyAlert;

import java.util.List;

// 查询， 新增， 更新， 删除
@Mapper
public interface EnergyAlertMapper {

    // 查询所有记录
    List<EnergyAlert> selectAllEnergyAlerts();

    // 根据 ID 查询记录
    EnergyAlert selectEnergyAlertById(Integer id);



    // 插入新记录
    int insertEnergyAlert(EnergyAlert alert);



    // 更新记录
    int updateEnergyAlert(EnergyAlert alert);



    // 删除记录
    int deleteEnergyAlert(Integer id);

}