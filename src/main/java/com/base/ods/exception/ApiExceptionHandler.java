package com.base.ods.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleEntityNotFoundException(Exception exception) {
        List<String> errors = new ArrayList<>();
        errors.add(exception.getMessage());
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, errors, LocalDateTime.now());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(/*violation.getRootBeanClass().getName() + " " + */ violation.getPropertyPath() + ": "
                    + violation.getMessage());
        }

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, errors, LocalDateTime.now());
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);

        //return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleEntityAlreadyExistsException(Exception exception) {
        List<String> errors = new ArrayList<>();
        errors.add(exception.getMessage());
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, errors, LocalDateTime.now());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}