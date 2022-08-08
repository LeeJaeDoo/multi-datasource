//package com.jd.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.transaction.ChainedTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
///**
// * @author Jaedoo Lee
// */
//@Configuration
//public class ChainedTransactionConfig {
//
//    @Bean("multiTransactionManager")
//    public PlatformTransactionManager transactionManager(@Qualifier("domain1TransactionManager") PlatformTransactionManager d1TxManager, @Qualifier("domain2TransactionManager") PlatformTransactionManager d2TxManager) {
//        return new ChainedTransactionManager(d1TxManager, d2TxManager);
//    }
//
//}
