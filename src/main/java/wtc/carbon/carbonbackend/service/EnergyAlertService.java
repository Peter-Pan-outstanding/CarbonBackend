package wtc.carbon.carbonbackend.service;


import wtc.carbon.carbonbackend.entity.EnergyAlert;

import java.util.List;

public interface EnergyAlertService {

    // 根据 ID 查询记录
    EnergyAlert getEnergyAlertById(Integer id);

    // 查询所有记录
    List<EnergyAlert> getAllEnergyAlerts();

    // 插入新记录
    boolean addEnergyAlert(EnergyAlert alert);

    // 更新记录
    boolean updateEnergyAlert(EnergyAlert alert);

    // 删除记录
    boolean deleteEnergyAlert(Integer id);
}
