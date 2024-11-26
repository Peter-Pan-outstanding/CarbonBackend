package wtc.carbon.carbonbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.entity.ProcessModeling;
import wtc.carbon.carbonbackend.mapper.ProcessMapper;
import wtc.carbon.carbonbackend.service.ProcessService;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessMapper projectMapper;
    @Override
    public List<ProcessModeling> getProcessModeling(int pageNumber, int pageSize, String search) {
        int offset = (pageNumber - 1) * pageSize;
        return projectMapper.getProcessModeling(pageSize, offset, search);
    }

    @Override
    public boolean updateProcess(ProcessModeling alert) {
        return projectMapper.updateProcess(alert) >= 1;
    }

    @Override
    public boolean saveProcess(ProcessModeling alert) {
        return projectMapper.saveProcess(alert) >= 1;
    }

    @Override
    public boolean deleteProcess(Integer id) {
        return projectMapper.deleteProcess(id) >= 1;
    }
}
