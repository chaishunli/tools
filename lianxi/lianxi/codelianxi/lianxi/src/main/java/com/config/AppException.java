package com.config;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class AppException extends RuntimeException{
    private String code;
    private String message;
    private HttpStatus httpStatus;
    public AppException(String code, String message, HttpStatus httpStatus){
        super(message);
        this.code=code;
        this.message=message;
        this.httpStatus=httpStatus;
    }
}
