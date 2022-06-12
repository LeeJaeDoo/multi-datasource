package com.jd.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.experimental.UtilityClass;

/**
 * @author Jaedoo Lee
 */
@UtilityClass
public class JacksonUtils {

    private static ObjectMapper getMapper() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class,
                                     new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(javaTimeModule);

        return mapper;
    }

    public static String toJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = getMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        return mapper.writeValueAsString(object);
    }

}
