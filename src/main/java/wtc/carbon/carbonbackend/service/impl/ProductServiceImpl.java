package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import wtc.carbon.carbonbackend.entity.Product;
import wtc.carbon.carbonbackend.mapper.ProductMapper;
import wtc.carbon.carbonbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    private static final int WARNING_LINE = 100;

    @Override
    public Map<String, Object> getAllProducts() {
        List<Product> products = productMapper.getAllProducts();
        HashMap<String, Object> map = new HashMap<>();
        map.put("products", products);
        map.put("warningLine", WARNING_LINE);
        return map;
    }
}
