package com.example.identify.service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error"),
    INVALID_KEY(1000,"Invalid message key"),
    USER_EXISTED(1001,"User existed"),
    USERNAME_INVALID(1002,"Username must be at least 3 character"),
    USERPASSWORD_INVALID(1003,"Password must be at least 8 character")

    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
