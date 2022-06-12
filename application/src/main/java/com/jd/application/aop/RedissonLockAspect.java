//package com.jd.application.aop;
//
//import com.jd.common.annotation.RedissonLock;
//import com.jd.exception.CommonException;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.springframework.context.expression.MethodBasedEvaluationContext;
//import org.springframework.core.DefaultParameterNameDiscoverer;
//import org.springframework.expression.EvaluationContext;
//import org.springframework.expression.ExpressionParser;
//import org.springframework.expression.spel.standard.SpelExpressionParser;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author Jaedoo Lee
// */
//@Aspect
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class RedissonLockAspect {
//
//    private final RedissonClient redissonClient;
//    private final ExpressionParser parser = new SpelExpressionParser();
//
////    @Around("@annotation(redissonLock)")
////    public Object redissonLocking(ProceedingJoinPoint joinPoint, RedissonLock redissonLock) throws Throwable {
////        log.info("redisson lock start");
////        RLock lock = redissonClient.getLock(getValueBySpringExpression(joinPoint,
////                                                                       redissonLock.key()));
////
////        try {
////            if (!lock.tryLock(5, 2, TimeUnit.SECONDS)) {
////                throw new CommonException("Redis Lock fail");
////            }
////            joinPoint.proceed();
////        } catch (Exception e) {
////            throw e;
////        } finally {
////            lock.unlock();
////            log.info("redisson lock end");
////        }
////
////        return null;
////    }
//
//    private String getValueBySpringExpression(JoinPoint joinPoint, String key) {
//        EvaluationContext context = new MethodBasedEvaluationContext(joinPoint.getTarget(),
//                                                                     ((MethodSignature)joinPoint.getSignature()).getMethod(),
//                                                                     joinPoint.getArgs(),
//                                                                     new DefaultParameterNameDiscoverer());
//        return String.valueOf(parser.parseExpression(key).getValue(context));
//    }
//
//}
