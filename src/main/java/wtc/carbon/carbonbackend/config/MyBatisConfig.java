package wtc.carbon.carbonbackend.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wtc.carbon.carbonbackend.typeHandler.EnergyStatusTypeHandler;

import javax.sql.DataSource;

@Configuration
@MapperScan("wtc.carbon.carbonbackend.mapper")
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeHandlers(new TypeHandler[]{new EnergyStatusTypeHandler()});
        return factoryBean.getObject();
    }
}
