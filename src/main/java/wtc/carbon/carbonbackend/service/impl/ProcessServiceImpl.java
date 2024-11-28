package wtc.carbon.carbonbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wtc.carbon.carbonbackend.common.PageBean;
import wtc.carbon.carbonbackend.entity.ProcessModeling;
import wtc.carbon.carbonbackend.mapper.ProcessMapper;
import wtc.carbon.carbonbackend.service.ProcessService;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessMapper projectMapper;
    @Override
    public PageBean<ProcessModeling> getProcessModeling(int pageNumber, int pageSize, String search) {
        PageBean<ProcessModeling> pb = new PageBean<>();

        PageHelper.startPage(pageNumber, pageSize);

        List<ProcessModeling> pm = projectMapper.getProcessModeling(search);

        Page<ProcessModeling> p = (Page<ProcessModeling>) pm;

        pb.setRecords(p.getResult());
        pb.setTotal(p.getTotal());
        return pb;
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

    @Override
    public List<ProcessModeling> list() {
        return projectMapper.list();
    }
}
