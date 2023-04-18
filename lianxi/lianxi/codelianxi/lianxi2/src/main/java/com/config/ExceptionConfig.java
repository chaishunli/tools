package com.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler({AppException.class})
    public ResponseEntity operation(AppException ex){
        Map<String,String> body =new HashMap();
        body.put("code",ex.getCode());
        body.put("message",ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(body);
    }
}
