package com.example.demo.config.exception;

public enum CustomExceptionType {
    USER_INPUT_ERROR(400,"用户输入异常"),
    SYSTEM_ERROR(500,"用户输入异常"),
    OTHER_ERROR(999,"用户输入异常");
    CustomExceptionType(int code,String typeDesc){
        this.code = code;
        this.typeDesc = typeDesc;
    }
    private int code;
    private String typeDesc;

    public int getCode() {
        return code;
    }

    public String getTypeDesc() {
        return typeDesc;
    }
}
