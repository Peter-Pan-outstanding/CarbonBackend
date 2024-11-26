package wtc.carbon.carbonbackend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.FactoryModeling;
import wtc.carbon.carbonbackend.service.FactoryService;

import java.util.List;

@RestController
@RequestMapping("/factory")
public class FactoryController {

    @Autowired
    private FactoryService factoryService;

    //查询所有工厂信息
    @GetMapping
    public Result<List<FactoryModeling>> list(){
        List<FactoryModeling> fm = factoryService.list();
        return Result.success(fm);
    }
}
