package wtc.carbon.carbonbackend.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import wtc.carbon.carbonbackend.common.Result;
import wtc.carbon.carbonbackend.entity.CarbonReduction;
import wtc.carbon.carbonbackend.mapper.CarbonReductionMapper;
import wtc.carbon.carbonbackend.service.CarbonReductionService;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CarbonReductionServiceImpl implements CarbonReductionService {
    @Resource
    private CarbonReductionMapper carbonReductionMapper;

    @Override
    public HashMap<String, Number> getProjectData() {
        int amountAllProjects = carbonReductionMapper.getAmountAllProjects();
        double amountInvestment = carbonReductionMapper.getAmountInvestment();
        double amountReducedCarbon = carbonReductionMapper.getAmountReducedCarbon();
        double amountOriginalCarbon = carbonReductionMapper.getAmountOriginalCarbon();

        double reduction = amountOriginalCarbon - amountReducedCarbon;
        double energySaveRate = amountReducedCarbon / amountOriginalCarbon;
        HashMap<String, Number> map = new HashMap<>();
        map.put("amountAllProjects", amountAllProjects);
        map.put("amountInvestment", amountInvestment);
        map.put("reduction", reduction);
        map.put("energySaveRate", energySaveRate);

        return map;
    }

    @Override
    public Map<String, Double> getCarbonTendency() {
        List<CarbonReduction> records = carbonReductionMapper.getAllCarbonReduction();

        // 格式化器，将日期转换为 "yyyy-M-d"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

        // 使用 Java Stream 分组并聚合
        Map<String, Double> monthlySumMap = records.stream()
                .collect(Collectors.groupingBy(
                        record -> {
                            // 将 reportTime 格式化为 "yyyy-M-d"，固定为该月1日
                            LocalDate reportDate = record.getReportTime().toLocalDate().withDayOfMonth(1);
                            return reportDate.format(formatter);
                        },
                        // 聚合计算 reducedCarbonEmission 总和
                        Collectors.summingDouble(CarbonReduction::getReducedCarbonEmission)
                ));

        return monthlySumMap;


    }


}
