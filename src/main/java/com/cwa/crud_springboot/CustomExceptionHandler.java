package com.cwa.crud_springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ApiError> handlePersonNotFoundException(PersonNotFoundException e) {
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setCode(HttpStatus.NOT_FOUND.value());
        apiError.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception e) {
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiError.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
