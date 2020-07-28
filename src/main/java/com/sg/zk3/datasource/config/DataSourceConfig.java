package com.sg.zk3.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.sg.zk3.datasource.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.Driver;
import java.util.HashMap;

/**
 * @author junwei.liang01@ucarinc.com
 * @date 2020/7/28 14:40
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DynamicDataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(new HashMap<>());
        return dynamicDataSource;
    }
}