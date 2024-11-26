package wtc.carbon.carbonbackend.service;

import java.util.List;

import wtc.carbon.carbonbackend.entity.ProcessModeling;

public interface ProcessService {
    List<ProcessModeling> getProcessModeling(int pageNumber, int pageSize, String search);

    boolean updateProcess(ProcessModeling alert);

    boolean saveProcess(ProcessModeling alert);

    boolean deleteProcess(Integer id);
}
