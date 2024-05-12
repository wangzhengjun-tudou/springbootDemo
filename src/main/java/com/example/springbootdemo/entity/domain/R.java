package com.example.springbootdemo.entity.domain;

import lombok.Data;


public class R<T> {
    private Integer code;
    private String message;
    private T data;

    private R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 快速创建成功响应的方法
    public static <T> R<T> ok(T data) {
        return new R<>(200, "Success", data);
    }

    // 快速创建成功响应的方法（无数据）
    public static <T> R<T> ok() {
        return new R<>(200, "Success", null);
    }

    public static <T> R<T> failed(String message) {
        return new R<>(Constants.FAIL, message, null);
    }

    // 快速创建失败响应的方法
    public static <T> R<T> error(Integer code, String message) {
        return new R<>(code, message, null);
    }

    // Getter 和 Setter 方法
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

