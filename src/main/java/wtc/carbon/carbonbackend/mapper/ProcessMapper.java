package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import wtc.carbon.carbonbackend.entity.ProcessModeling;
import wtc.carbon.carbonbackend.entity.ProjectMaintenance;

import java.util.List;

@Mapper
public interface ProcessMapper {
    List<ProcessModeling> getProcessModeling(int limit, int offset, String search);

    int updateProcess(ProcessModeling alert);

    int saveProcess(ProcessModeling alert);

    int deleteProcess(Integer id);
}
