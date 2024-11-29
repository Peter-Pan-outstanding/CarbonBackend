package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import wtc.carbon.carbonbackend.entity.SalesStatistics;
import java.util.List;

@Mapper
public interface SalesStatisticsMapper {

    @Select("SELECT * FROM a_sales_statistics")
    List<SalesStatistics> getAllSalesStatistics();
}
