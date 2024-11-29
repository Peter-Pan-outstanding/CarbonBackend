package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public Result<?> getAllProducts() {
        Map<String, Object> products = productService.getAllProducts();
        if (!products.isEmpty()) {
            return Result.success(products);
        } else {
            return Result.error(404, "获取产品数据失败，请联系管理员");
        }
    }
}
