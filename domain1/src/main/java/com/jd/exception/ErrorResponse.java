package com.jd.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jd.util.LogUtils;

import java.util.List;

import lombok.Getter;

/**
 * @author Jaedoo Lee
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private final String message;
    private final List<ValidationResponse> valids;
    private final String stackTrace;

    public ErrorResponse(String message) {
        this.message = message;
        this.valids = null;
        this.stackTrace = null;
    }

    public ErrorResponse(String message, Exception ex) {
        this.message = message;
        this.valids = null;
        this.stackTrace = LogUtils.getStackTrace(ex);
    }

    public ErrorResponse(ErrorMessage message, Throwable ex) {
        this.message = message.getMessage();
        this.valids = null;
        this.stackTrace = LogUtils.getStackTrace(ex);
    }

    public ErrorResponse(ErrorMessage message, List<ValidationResponse> valids) {
        this.message = message.getMessage();
        this.valids = valids;
        this.stackTrace = null;
    }
}
