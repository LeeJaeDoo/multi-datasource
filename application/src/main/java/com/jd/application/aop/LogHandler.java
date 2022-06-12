//package com.jd.application.aop;
//
//import com.jd.common.HeaderConstants;
//import com.jd.exception.response.ErrorResponse;
//import com.jd.util.LogUtils;
//
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.MDC;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//
//import lombok.experimental.ExtensionMethod;
//
///**
// * @author Jaedoo Lee
// */
//@Component
//@Aspect
//@ExtensionMethod(StringUtils.class)
//public class LogHandler {
//
////    @Pointcut("execution(* com.jd.presentation.*.*(..))")
////    private void apiController() {}
////
////    @Pointcut("execution(* com.jd.exception.CustomExceptionHandler.requestValidation(..))")
////    private void requestValidation() {}
////
////    @Before("apiController() || requestValidation()")
////    public void preRequest() {
////        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
////        String traceId = request.getHeader(HeaderConstants.TRACE_ID).defaultString(UUID.randomUUID().toString());
////
////        request.setAttribute(HeaderConstants.TRACE_ID, traceId);
////        MDC.put(HeaderConstants.TRACE_ID, traceId);
////    }
////
////    @AfterReturning(pointcut = "apiController()", returning = "response")
////    public void successLogging(JoinPoint joinPoint, Object response) {
////        LogUtils.logger(joinPoint.getSignature(), joinPoint.getArgs(), response);
////        MDC.clear();
////    }
////
////    @AfterReturning(pointcut = "requestValidation()", returning = "error")
////    public void validationExceptionLogging(ErrorResponse error) {
////        LogUtils.validationLogger(error);
////        MDC.clear();
////    }
////
////    @AfterThrowing(pointcut = "apiController()", throwing = "ex")
////    public void exceptionLogging(JoinPoint joinPoint, Throwable ex) {
////        LogUtils.exceptionLogger(joinPoint.getSignature(), joinPoint.getArgs(), ex);
////        MDC.clear();
////    }
//
//}
