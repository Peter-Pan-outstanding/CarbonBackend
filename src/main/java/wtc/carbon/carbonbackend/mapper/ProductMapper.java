package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import wtc.carbon.carbonbackend.entity.Product;
import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("select * from a_product")
    List<Product> getAllProducts();
}
