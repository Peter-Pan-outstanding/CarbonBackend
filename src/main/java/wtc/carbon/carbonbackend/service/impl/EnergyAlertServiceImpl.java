package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.EnergyAlert;
import wtc.carbon.carbonbackend.mapper.EnergyAlertMapper;
import wtc.carbon.carbonbackend.service.EnergyAlertService;

import java.util.List;


@Service
public class EnergyAlertServiceImpl implements EnergyAlertService {

    @Resource
    private EnergyAlertMapper energyAlertMapper;

    @Override
    public EnergyAlert getEnergyAlertById(Integer id) {
        return energyAlertMapper.selectEnergyAlertById(id);
    }

    @Override
    public List<EnergyAlert> getAllEnergyAlerts() {
        return energyAlertMapper.selectAllEnergyAlerts();
    }

    @Override
    public boolean addEnergyAlert(EnergyAlert alert) {
        return energyAlertMapper.insertEnergyAlert(alert) >= 1;
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
