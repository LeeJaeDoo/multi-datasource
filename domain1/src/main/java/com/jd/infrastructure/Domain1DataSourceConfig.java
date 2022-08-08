//package com.jd.infrastructure;
//
//import com.zaxxer.hikari.HikariDataSource;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
///**
// * @author Jaedoo Lee
// */
//@Configuration
//public class Domain1DataSourceConfig {
//
////    @Bean
////    @ConfigurationProperties("spring.datasource.hikari")
////    public DataSource dataSource() {
////        return DataSourceBuilder.create().type(HikariDataSource.class).build();
////    }
//
//    @Bean
//    public DataSource dataSource() {
//
//        Properties properties = new Properties();
//        properties.setProperty("user", "root");
//        properties.setProperty("password", "a90a1027a");
//        properties.setProperty("url", "jdbc:mysql://localhost:3306/investment?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true");
//
//        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
//        dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
//        dataSource.setXaProperties(properties);
//
//        return dataSource;
//    }
//
//    @Bean
////    @Primary
//    public DataSource domain1DataSource() {
//        return new LazyConnectionDataSourceProxy(dataSource());
//    }
//
//}
