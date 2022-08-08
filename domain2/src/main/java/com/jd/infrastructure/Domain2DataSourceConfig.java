package com.jd.infrastructure;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import java.util.Properties;

import javax.sql.DataSource;

/**
 * @author Jaedoo Lee
 */
@Configuration
@EnableJpaRepositories(
    basePackages = "com.jd.domain2",
    entityManagerFactoryRef = "domain2EntityManagerFactory",
    transactionManagerRef = "jtaTransactionManager"
)
public class Domain2DataSourceConfig {

    /*@Bean
    @ConfigurationProperties("spring.datasource.domain2.hikari")
    public DataSource domain2OriginDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }*/

//    @Bean(name = "domain2DataSource")
//    public DataSource domain2DataSource() {
//
//        Properties properties = new Properties();
//        properties.setProperty("user", "root");
//        properties.setProperty("password", "a90a1027a");
//        properties.setProperty("url", "jdbc:mysql://localhost:3306/member?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true");
//
//        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
//        dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
//        dataSource.setXaProperties(properties);
//
//        return dataSource;
//    }
//
//    @Bean(name = "domain2DataSource")
//    public DataSource domain2DataSource() {
//        return new LazyConnectionDataSourceProxy(domain2OriginDataSource());
//    }

}
