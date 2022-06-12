package com.jd.config.resolver;

import com.jd.common.HeaderConstants;
import com.jd.exception.AuthenticationException;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import lombok.experimental.ExtensionMethod;

/**
 * @author Jaedoo Lee
 */
@Component
@ExtensionMethod(StringUtils.class)
public class HeaderArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return (Long.class.isAssignableFrom(parameter.getParameterType())
                || long.class.isAssignableFrom(parameter.getParameterType()))
               && "userHeaderId".equals(parameter.getParameterName());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        String userIdStr = webRequest.getHeader(HeaderConstants.USER_ID_HEADER).defaultString(Strings.EMPTY);
        validate(userIdStr);

        return Long.parseLong(userIdStr);
    }

    private void validate(String userId) {
        if (userId.isBlank() || Long.parseLong(userId) <= 0) {
            throw new AuthenticationException();
        }
    }
}
