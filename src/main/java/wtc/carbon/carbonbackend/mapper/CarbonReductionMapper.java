package wtc.carbon.carbonbackend.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarbonReductionMapper {
    // 获取累计招标项目的数量
    int getAmountAllProjects();

    // 获取总投资额
    double getAmountInvestment();

    // 获取所有原先要排放的碳的总和
    double getAmountOriginalCarbon();

    // 获取减排之后的碳排放的总和
    double getAmountReducedCarbon();

}
