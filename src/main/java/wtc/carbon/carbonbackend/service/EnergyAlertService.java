package wtc.carbon.carbonbackend.service;


import wtc.carbon.carbonbackend.entity.EnergyAlert;
import wtc.carbon.carbonbackend.enums.EnergyStatus;

import java.util.List;

public interface EnergyAlertService {

    // 根据 ID 查询记录
    EnergyAlert getEnergyAlertById(Integer id);

    // 查询所有记录
    List<EnergyAlert> getAllEnergyAlerts();

    // 根据条件查询
    List<EnergyAlert> getEnergyAlertsByConditions(String monitoringPointName,
                                                  String monitoringPointAddress,
                                                  Integer status);

    // 分页查询所有的EnergyAlert
    List<EnergyAlert> getEnergyAlertsWithPagination(int pageNumber, int pageSize);



    // 插入新记录
    boolean addEnergyAlert(EnergyAlert alert);

    // 更新记录
    boolean updateEnergyAlert(EnergyAlert alert);

    // 删除记录
    boolean deleteEnergyAlert(Integer id);
}
