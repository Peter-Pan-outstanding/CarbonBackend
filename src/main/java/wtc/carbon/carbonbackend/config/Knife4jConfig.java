package wtc.carbon.carbonbackend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("碳排放接口文档")
                        .version("1.0")
                );
    }

    @Bean
    public GroupedOpenApi EnergyAlertApi(){
        return GroupedOpenApi.builder()
                .group("能效预警")
                .pathsToMatch("/energyAlerts/**")
                .build();
    }

    @Bean
    public GroupedOpenApi ProjectMaintenanceApi(){
        return GroupedOpenApi.builder()
                .group("项目维护")
                .pathsToMatch("/projectMaintenance/**")
                .build();
    }

}
