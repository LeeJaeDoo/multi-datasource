//package com.jd.common;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionDefinition;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.support.DefaultTransactionDefinition;
//import org.springframework.transaction.support.TransactionSynchronizationManager;
//
//import java.util.List;
//import java.util.Stack;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author Jaedoo Lee
// */
//@Component
//@Scope("prototype")
//@Slf4j
//public class CommonTransactionManager {
//
//    private final ThreadLocal<Stack<TransactionStatus>> status = new ThreadLocal<>();
//    private int isolationLevel = TransactionDefinition.ISOLATION_DEFAULT;
//
//    @Autowired
//    private PlatformTransactionManager transactionManager;
//
//    private int timeout = DefaultTransactionDefinition.TIMEOUT_DEFAULT;
//
//    public void start() {
//        log.info("NCPTransactionManager - start / start");
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        def.setName("ecsTransaction");
//        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
//        def.setIsolationLevel(isolationLevel);
//        def.setTimeout(timeout);
//        Stack<TransactionStatus> transactionStatuses = status.get();
//        if (transactionStatuses == null) {
//            transactionStatuses = new Stack();
//            status.set(transactionStatuses);
//        }
//        transactionStatuses.push(transactionManager.getTransaction(def));
//        TransactionSynchronizationManager.setCurrentTransactionReadOnly(false);
//        log.info("NCPTransactionManager - start / end");
//    }
//
//    public void rollback() {
//        Stack<TransactionStatus> transactionStatuses = status.get();
//        TransactionStatus current = transactionStatuses.pop();
//        try {
//            log.info("NCPTransactionManager - rollback / start");
//            transactionManager.rollback(current);
//            log.info("NCPTransactionManager - rollback / end");
//        } catch (Exception e) {
//            log.error("rollback error", e);
//        } finally {
//            if (transactionStatuses.empty()) {
//                status.remove();
//            }
//        }
//    }
//
//    public void commit() {
//        List<TransactionStatus> transactionStatuses = status.get();
//        TransactionStatus current = transactionStatuses.get(transactionStatuses.size() - 1);
//        try {
//            log.info("NCPTransactionManager - commit / start");
//            transactionManager.commit(current);
//            log.info("NCPTransactionManager - commit / end");
//        } catch (Exception e) {
//            log.error("commit error", e);
//        } finally {
//            transactionStatuses.remove(current);
//            if (transactionStatuses.size() == 0) {
//                status.remove();
//            }
//        }
//    }
//
//    public int getIsolationLevel() {
//        return isolationLevel;
//    }
//
//    public void setIsolationLevel(int isolationLevel) {
//        this.isolationLevel = isolationLevel;
//    }
//
//    public int getTimeout() {
//        return this.timeout;
//    }
//
//    public void setTimeout(int timeout) {
//        this.timeout = timeout;
//    }
//
//}
