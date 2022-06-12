package com.jd.exception;

/**
 * @author Jaedoo Lee
 */
public class InvestorException extends CommonException {

    public InvestorException(ErrorMessage message) {
        super(message.getMessage());
    }
}
