package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.EnergyAlert;
import wtc.carbon.carbonbackend.mapper.EnergyAlertMapper;
import wtc.carbon.carbonbackend.service.EnergyAlertService;

import java.util.HashMap;
import java.util.List;


@Service
public class EnergyAlertServiceImpl implements EnergyAlertService {

    @Resource
    private EnergyAlertMapper energyAlertMapper;

    @Override
    public EnergyAlert getEnergyAlertById(Integer id) {
        return energyAlertMapper.getEnergyAlertById(id);
    }

    @Override
    public List<EnergyAlert> getEnergyAlertsByConditions(String monitoringPointName, String monitoringPointAddress, Integer status){
        return energyAlertMapper.getEnergyAlertsByConditions(monitoringPointName, monitoringPointAddress, status);
    }

    @Override
    public HashMap<String,Object> getEnergyAlertsWithPagination(int pageNumber, int pageSize){
        int offset = (pageNumber - 1) * pageSize;
        List<EnergyAlert> pagination = energyAlertMapper.getEnergyAlertsWithPagination(pageSize, offset);
        int total = energyAlertMapper.getEnergyAlertsCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("records", pagination);
        map.put("total", total);

        return map;
    }


    @Override
    public List<EnergyAlert> getAllEnergyAlerts() {
        return energyAlertMapper.getAllEnergyAlerts();
    }

    @Override
    public boolean addEnergyAlert(EnergyAlert alert) {
        return energyAlertMapper.saveEnergyAlert(alert) >= 1;
    }

    @Override
    public boolean updateEnergyAlert(EnergyAlert alert) {
        return energyAlertMapper.updateEnergyAlert(alert) >= 1;
    }

    @Override
    public boolean deleteEnergyAlert(Integer id) {
        return energyAlertMapper.deleteEnergyAlert(id) >= 1;
    }
}
