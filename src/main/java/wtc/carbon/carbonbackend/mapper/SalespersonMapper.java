package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import wtc.carbon.carbonbackend.entity.Salesperson;
import java.util.List;

@Mapper
public interface SalespersonMapper {

    @Select("SELECT * FROM a_salesperson")
    List<Salesperson> getAllSalespersons();
}
