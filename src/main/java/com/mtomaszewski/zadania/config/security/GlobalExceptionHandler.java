package com.mtomaszewski.zadania.config.security;


import com.mtomaszewski.zadania.exception.CurrencyNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CurrencyNotFound.class)
    public ResponseEntity<Object> handleCurrencyNotFoundException(CurrencyNotFound ex){
        Map<String, String> error = Collections.singletonMap("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
