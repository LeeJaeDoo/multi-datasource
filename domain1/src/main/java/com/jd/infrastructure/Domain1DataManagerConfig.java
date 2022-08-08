//package com.jd.infrastructure;
//
//import org.hibernate.engine.transaction.jta.platform.internal.AtomikosJtaPlatform;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import java.util.Map;
//import java.util.Properties;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
///**
// * @author Jaedoo Lee
// */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//    basePackages = "com.jd.domain",
//    entityManagerFactoryRef = "domain1entityManagerFactory",
//    transactionManagerRef = "jtaTransactionManager"
//)
//public class Domain1DataManagerConfig {
//
//    protected void setConfigureEntityManagerFactory(LocalContainerEntityManagerFactoryBean factory) {
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setJpaPropertyMap(Map.of("hibernate.hbm2ddl.auto", "none",
//                                         "hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect",
//                                         "hibernate.show_sql", "true",
//                                         "hibernate.format_sql", "true",
//                                         "hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName()
//        ));
//        factory.afterPropertiesSet();
//    }
//
//    @Bean(name = "domain1DataSource")
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
//    @Bean("domain1entityManagerFactory")
////    @Primary
//    public EntityManagerFactory domain1entityManagerFactory(@Qualifier("domain1DataSource") DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setPackagesToScan("com.jd.domain");
//        factory.setPersistenceUnitName("entityManagerFactory");
//        setConfigureEntityManagerFactory(factory);
//        return factory.getObject();
//    }
//
////    @Bean
////    @Primary
////    public PlatformTransactionManager domain1TransactionManager(@Qualifier("domain1entityManagerFactory") EntityManagerFactory domain1entityManagerFactory) {
////        JpaTransactionManager tm = new JpaTransactionManager();
////        tm.setEntityManagerFactory(domain1entityManagerFactory);
////        return tm;
////    }
//}
