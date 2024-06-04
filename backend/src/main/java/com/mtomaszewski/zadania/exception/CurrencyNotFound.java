package com.mtomaszewski.zadania.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CurrencyNotFound extends RuntimeException {
    public CurrencyNotFound(String msg){
        super(msg);
    }
}
