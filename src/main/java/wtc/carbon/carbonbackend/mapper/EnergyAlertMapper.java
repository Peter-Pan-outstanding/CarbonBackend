package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.*;
import wtc.carbon.carbonbackend.entity.EnergyAlert;

import java.util.List;

// 查询， 新增， 更新， 删除
@Mapper
public interface EnergyAlertMapper {

    // 查询所有记录
    List<EnergyAlert> getAllEnergyAlerts();

    // 根据 ID 查询记录
    EnergyAlert getEnergyAlertById(Integer id);

    // 根据条件查询List<EnergyAlert>
    List<EnergyAlert> getEnergyAlertsByConditions( String monitoringPointName,
                                          String monitoringPointAddress,
                                          Integer status);

    // 分页查询所有的EnergyAlert
    List<EnergyAlert> getEnergyAlertsWithPagination(int limit, int offset);


    // 插入新记录
    int saveEnergyAlert(EnergyAlert alert);

    // 获取总数量
    int getEnergyAlertsCount();


    // 更新记录
    int updateEnergyAlert(EnergyAlert alert);



    // 删除记录
    int deleteEnergyAlert(Integer id);

}
