package wtc.carbon.carbonbackend.service;

import wtc.carbon.carbonbackend.common.PageBean;
import wtc.carbon.carbonbackend.entity.ProcessModeling;

import java.util.List;

public interface ProcessService {
    PageBean<ProcessModeling> getProcessModeling(int pageNumber, int pageSize, String search);

    boolean updateProcess(ProcessModeling alert);

    boolean saveProcess(ProcessModeling alert);

    boolean deleteProcess(Integer id);

    List<ProcessModeling> list();
}
