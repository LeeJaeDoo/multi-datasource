package com.jd.infrastructure;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;

/**
 * @author Jaedoo Lee
 */
@Configuration
public class Domain2DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.domain2.hikari")
    public DataSource domain2OriginDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "domain2DataSource")
    public DataSource domain2DataSource() {
        return new LazyConnectionDataSourceProxy(domain2OriginDataSource());
    }

}
