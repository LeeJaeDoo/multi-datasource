package com.jd.exception;



import com.jd.util.CollectionUtils;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.ConversionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import lombok.experimental.ExtensionMethod;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jaedoo Lee
 */
@RestControllerAdvice
@ExtensionMethod(CollectionUtils.class)
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> requestUnauthorized(AuthenticationException ex) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler({
        BindException.class,
        ConversionException.class, TypeMismatchException.class,
        MethodArgumentNotValidException.class,
    })
    public ResponseEntity<?> requestValidation(BindingResult results) {

        return ResponseEntity.badRequest()
                             .body(new ErrorResponse(ErrorMessage.BAD_REQUEST,
                                                     results.getFieldErrors()
                                                            .map(result -> new ValidationResponse(result.getField(),
                                                                                                  result.getDefaultMessage(),
                                                                                                  result.getRejectedValue()))));
    }

    @ExceptionHandler({
        ConstraintViolationException.class,
        HttpMessageNotReadableException.class,
        IllegalArgumentException.class,
        ValidationException.class
    })
    public ResponseEntity<?> requestValidation(Throwable ex) {

        return ResponseEntity.badRequest()
                             .body(new ErrorResponse(ErrorMessage.BAD_REQUEST, ex));
    }

    @ExceptionHandler({ProductException.class, InvestorException.class})
    public ResponseEntity<?> exceptionResponse(Exception ex) {

        return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage(), ex));
    }

    @ExceptionHandler({Exception.class, CommonException.class})
    public ResponseEntity<?> internalError(Throwable ex) {
        log.error(Arrays.toString(ex.getStackTrace()));
        return ResponseEntity.internalServerError().body(new ErrorResponse(ErrorMessage.INTERNAL_SERVER_ERROR, ex));
    }

}
