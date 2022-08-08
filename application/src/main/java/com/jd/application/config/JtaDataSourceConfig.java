package com.jd.application.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

import org.hibernate.engine.transaction.jta.platform.internal.AtomikosJtaPlatform;
import org.hibernate.resource.transaction.backend.jta.internal.JtaTransactionAdapterUserTransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jaedoo Lee
 */
@Configuration
@EnableTransactionManagement
@Slf4j
public class JtaDataSourceConfig {

    /*@Value("${spring.jta.atomikos.datasource.domain1.unique-resource-name}")
    private String xaUniqueResourceName;

    @Value("${spring.jta.atomikos.datasource.domain1.xa-data-source-class-name}")
    private String xaDataSourceClassName;

    @Value("${spring.jta.atomikos.datasource.domain1.xa-properties.user}")
    private String xaUser;

    @Value("${spring.jta.atomikos.datasource.domain1.xa-properties.password}")
    private String xaPassword;

    @Value("${spring.jta.atomikos.datasource.domain1.xa-properties.url}")
    private String xaUrl;

    @Value("${spring.jta.atomikos.datasource.domain2.unique-resource-name}")
    private String xaUniqueResourceName1;

    @Value("${spring.jta.atomikos.datasource.domain2.xa-data-source-class-name}")
    private String xaDataSourceClassName1;

    @Value("${spring.jta.atomikos.datasource.domain2.xa-properties.user}")
    private String xaUser1;

    @Value("${spring.jta.atomikos.datasource.domain2.xa-properties.password}")
    private String xaPassword1;

    @Value("${spring.jta.atomikos.datasource.domain2.xa-properties.url}")
    private String xaUrl1;

    @Bean(name = "domain1XaDataSource")
    public DataSource xaForLegacyDataSource() {
        log.info("==================== xaForLegacyDataSource");
        Properties properties = new Properties();
        properties.setProperty("url", xaUrl);
        properties.setProperty("user", xaUser);
        properties.setProperty("password", xaPassword);

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName(xaUniqueResourceName);
        dataSource.setXaDataSourceClassName(xaDataSourceClassName);
        dataSource.setXaProperties(properties);

        return dataSource;
    }

    @Bean(name = "domain2XaDataSource")
    public DataSource xaForLegacyDataSource1() {
        Properties properties = new Properties();
        properties.setProperty("url", xaUrl1);
        properties.setProperty("user", xaUser1);
        properties.setProperty("password", xaPassword1);

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setUniqueResourceName(xaUniqueResourceName1);
        dataSource.setXaDataSourceClassName(xaDataSourceClassName1);
        dataSource.setXaProperties(properties);

        return dataSource;
    }

    @Bean(name = "userTransaction")
    public UserTransaction userTransaction() throws Throwable {

        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(10000);
        return userTransactionImp;
    }

    @Bean(name = "atomikosTransactionManager")
    public UserTransactionManager atomikosTransactionManager() {

        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);

        return userTransactionManager;
    }*/

    protected void setConfigureEntityManagerFactory(LocalContainerEntityManagerFactoryBean factory) {
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaPropertyMap(Map.of("hibernate.hbm2ddl.auto", "none",
                                         "hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect",
                                         "hibernate.show_sql", "true",
                                         "hibernate.format_sql", "true",
                                         "hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName()
        ));
        factory.afterPropertiesSet();
    }

    @Bean(name = "domain1DataSource")
    public DataSource dataSource() {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "a90a1027a");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/investment?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true");

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
        dataSource.setXaProperties(properties);

        return dataSource;
    }

    @Bean("domain1entityManagerFactory")
    //    @Primary
    public EntityManagerFactory domain1entityManagerFactory(@Qualifier("domain1DataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("com.jd.domain");
        factory.setPersistenceUnitName("entityManagerFactory");
        setConfigureEntityManagerFactory(factory);
        return factory.getObject();
    }

    @Bean(name = "domain2DataSource")
    public DataSource domain2DataSource() {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "a90a1027a");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/member?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true");

        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
        dataSource.setXaProperties(properties);

        return dataSource;
    }

    @Bean(name = "domain2EntityManagerFactory")
    public EntityManagerFactory entityManagerFactory(@Qualifier("domain2DataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("com.jd.domain2");
        factory.setPersistenceUnitName("domain2EntityManager");
        setConfigureEntityManagerFactory(factory);
        return factory.getObject();
    }

    @Bean("jtaTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager() throws Exception {
        log.info("transactionManager() 실행");

        UserTransaction userTransaction = new UserTransactionImp();
        userTransaction.setTransactionTimeout(10000);

        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);

        return new JtaTransactionManager(
            userTransaction, userTransactionManager);
    }
}
