package com.jd.exception;

import lombok.Getter;

/**
 * @author Jaedoo Lee
 */
@Getter
public class ValidationResponse {

    private final String field;
    private final String message;
    private final Object rejectedValue;

    public ValidationResponse(String field, String message, Object rejectedValue) {
        this.field = field;
        this.message = message;
        this.rejectedValue = rejectedValue;
    }
}
