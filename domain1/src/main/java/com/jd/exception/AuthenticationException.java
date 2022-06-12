package com.jd.exception;

/**
 * @author Jaedoo Lee
 */
public class AuthenticationException extends CommonException {

    public AuthenticationException() {
        super(ErrorMessage.UNAUTHORIZED_REQUEST.getMessage());
    }
}
