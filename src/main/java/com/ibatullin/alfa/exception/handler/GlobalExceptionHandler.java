package com.ibatullin.alfa.exception.handler;

import com.ibatullin.alfa.exception.CurrentException;
import com.ibatullin.alfa.exception.ResponseMessage;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//https://habr.com/ru/post/342214/
@RestControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
        super();
    }

    @ExceptionHandler(CurrentException.class)
    public ResponseEntity<ResponseMessage> BaseException(Exception e) {
        return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.FORBIDDEN);
    }
}
