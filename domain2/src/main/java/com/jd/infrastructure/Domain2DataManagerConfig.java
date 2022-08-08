//package com.jd.infrastructure;
//
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
//    basePackages = "com.jd.domain2",
//    entityManagerFactoryRef = "domain2EntityManagerFactory",
//    transactionManagerRef = "jtaTransactionManager"
//)
//public class Domain2DataManagerConfig {
//
//    protected void setConfigureEntityManagerFactory(LocalContainerEntityManagerFactoryBean factory) {
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setJpaPropertyMap(Map.of("hibernate.hbm2ddl.auto", "none",
//                                         "hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect",
//                                         "hibernate.show_sql", "true",
//                                         "hibernate.format_sql", "true"));
//        factory.afterPropertiesSet();
//    }
//
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
//    @Bean(name = "domain2EntityManagerFactory")
//    public EntityManagerFactory entityManagerFactory(@Qualifier("domain2DataSource") DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setPackagesToScan("com.jd.domain2");
//        factory.setPersistenceUnitName("domain2EntityManager");
//        setConfigureEntityManagerFactory(factory);
//        return factory.getObject();
//    }
//
//    /*@Bean(name = "domain2TransactionManager")
//    public PlatformTransactionManager transactionManager(@Qualifier("domain2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager tm = new JpaTransactionManager();
//        tm.setEntityManagerFactory(entityManagerFactory);
//        return tm;
//    }*/
//}
