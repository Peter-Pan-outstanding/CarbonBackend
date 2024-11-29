package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import wtc.carbon.carbonbackend.entity.ProductionPlan;
import java.util.List;

@Mapper
public interface ProductionPlanMapper {

    @Select("SELECT * FROM a_production_plan")
    List<ProductionPlan> getAllProductionPlans();
}
