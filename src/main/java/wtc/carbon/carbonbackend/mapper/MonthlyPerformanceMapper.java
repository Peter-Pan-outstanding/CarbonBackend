package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import wtc.carbon.carbonbackend.entity.MonthlyPerformance;
import java.util.List;

@Mapper
public interface MonthlyPerformanceMapper {
    
    @Select("SELECT * FROM a_monthly_performance")
    List<MonthlyPerformance> getAllMonthlyPerformances();
}
