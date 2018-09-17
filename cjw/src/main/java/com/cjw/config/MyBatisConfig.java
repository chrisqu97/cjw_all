package com.cjw.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
/**
 * 扫描mapper所在包
 */
@MapperScan("com.cjw.dao.mapper")
public class MyBatisConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
