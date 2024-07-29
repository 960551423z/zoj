package com.camellia.zoj.common;

/**
 * @author: 阿庆
 * @date: 2024/7/27 上午10:46
 */

public enum HttpStatus {



    SUCCESS(200,"0k"),
    ERROR(500,"系统内部错误"),
    QUERY_NOT_FIND(404,"未查询到该数据");

    private final int code;

    private final String message;


    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
