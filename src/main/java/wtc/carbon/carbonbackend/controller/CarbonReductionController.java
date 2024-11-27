package wtc.carbon.carbonbackend.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.service.CarbonReductionService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/carbonReduction")
public class CarbonReductionController {
    @Resource
    private CarbonReductionService carbonReductionService;

    @GetMapping("/getProjectData")
    public Result<?> getProjectData(){
        HashMap<String, Number> data = carbonReductionService.getProjectData();
        if(data != null){
            return Result.success(data);
        }else {
            return Result.error(400,"获取数据失败，请重试");
        }
    }

    @GetMapping("/getCarbonTendency")
    public Result<?> getCarbonTendency(){
        Map<String, Double> tendency = carbonReductionService.getCarbonTendency();
        if(tendency != null){
            return Result.success(tendency);
        }else {
            return Result.error(400, "获取数据失败，请重试");
        }
    }

}
