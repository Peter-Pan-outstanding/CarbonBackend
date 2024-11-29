package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import wtc.carbon.carbonbackend.entity.SalesPlan;
import java.util.List;

@Mapper
public interface SalesPlanMapper {
    
    @Select("SELECT * FROM a_sales_plan")
    @Results({
            @Result(property = "actualSales", column = "actual_sales"),
            @Result(property = "plannedSales", column = "planned_sales")
    })
    List<SalesPlan> getAllSalesPlans();
}
