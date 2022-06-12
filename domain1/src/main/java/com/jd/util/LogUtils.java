package com.jd.util;

import org.aspectj.lang.Signature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import lombok.experimental.ExtensionMethod;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jaedoo Lee
 */
@UtilityClass
@Slf4j
@ExtensionMethod(JacksonUtils.class)
public class LogUtils {

    public static void logger(Signature signature, Object requestParams, Object response) {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

        try {
            log.info(
                "\n/--------------------------------------------------------------------------------------------------------------------------------------\n|method: {}\n|url: {}\n|result: success\n|request params: {}\n|response: {}\n\\--------------------------------------------------------------------------------------------------------------------------------------",
                signature,
                request.getRequestURL(),
                requestParams.toJson(),
                response.toJson()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validationLogger(Object response) {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        StringBuilder requestParams = new StringBuilder();
        requestParams.append("{");
        request.getParameterNames()
               .asIterator()
               .forEachRemaining(paramName -> requestParams.append(paramName)
                                                           .append(":")
                                                           .append(request.getParameter(paramName))
                                                           .append(","));

        try {
            log.error(
                "\n/--------------------------------------------------------------------------------------------------------------------------------------\n|method: {}\n|url: {}\n|result: fail\n|request params: {}\n|response params: {}\n\\--------------------------------------------------------------------------------------------------------------------------------------",
                request.getMethod(),
                request.getRequestURL(),
                requestParams.append("}").toString().replaceFirst(",}", "}"),
                response.toJson()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exceptionLogger(Signature signature, Object requestParams, Throwable ex) {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

        try {
            log.error(
                "\n/--------------------------------------------------------------------------------------------------------------------------------------\n|method: {}\n|url: {}\n|result: fail\n|request params: {}\n|exception: {}\n\\--------------------------------------------------------------------------------------------------------------------------------------",
                signature,
                request.getRequestURL(),
                requestParams.toJson(),
                getStackTrace(ex)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getStackTrace(Throwable ex) {
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));

        return sw.toString();
    }

}
