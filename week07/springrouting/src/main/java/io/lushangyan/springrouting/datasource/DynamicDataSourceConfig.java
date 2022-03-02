package io.lushangyan.springrouting.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置多数据源
 * @author lushangyan
 * @version V1.0.0
 */
@Configuration
public class DynamicDataSourceConfig {

    @Autowired
    Environment env;

    @Bean
    @ConfigurationProperties("spring.datasource.hikari.db0")
    public DataSource db0DataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.hikari.db0.jdbcUrl"));
        dataSource.setUsername(env.getProperty("spring.datasource.hikari.db0.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.hikari.db0.password"));

        return dataSource;

    }



    @Bean
    @ConfigurationProperties("spring.datasource.hikari.db1")
    public DataSource db1DataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.hikari.db1.jdbcUrl"));
        dataSource.setUsername(env.getProperty("spring.datasource.hikari.db1.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.hikari.db1.password"));

        return dataSource;

    }


    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource db0DataSource, DataSource db1DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(5);
        targetDataSources.put(DataSourceNames.DB0, db0DataSource);
        targetDataSources.put(DataSourceNames.DB1, db1DataSource);
        return new DynamicDataSource(db0DataSource, targetDataSources);
    }

}
