package com.camellia.zoj.exception;

import com.camellia.zoj.common.ResponseResult;

/**
 * @author: 阿庆
 * @date: 2024/7/27 下午3:57
 * 基本异常处理
 */


public class BaseException extends RuntimeException {

    private int code;
    private String msg;

    public BaseException() {
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(int code , String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
