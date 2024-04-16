package com.example.identify.service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1000,"Invalid message key",HttpStatus.BAD_REQUEST),
    USER_EXISTED(1001,"User existed",HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1002,"Username must be at least {min} character",HttpStatus.BAD_REQUEST),
    USERPASSWORD_INVALID(1003,"Password must be at least {min} character",HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1004,"User not existed",HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1005,"Unauthenticated",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1006,"You do not have permission",HttpStatus.FORBIDDEN),
    INVALID_DOB(1007,"Your age must be at least {min}",HttpStatus.BAD_REQUEST)
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;


}
