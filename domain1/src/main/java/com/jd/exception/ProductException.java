package com.jd.exception;

/**
 * @author Jaedoo Lee
 */
public class ProductException extends CommonException {

    public ProductException(ErrorMessage message) {
        super(message.getMessage());
    }

    public ProductException(String message) {
        super(message);
    }
}
