package com.jd.exception;

import lombok.Getter;

/**
 * @author Jaedoo Lee
 */
@Getter
public class CommonException extends RuntimeException {

    protected String message;

    public CommonException(String message) {
        this.message = message;
    }
}
