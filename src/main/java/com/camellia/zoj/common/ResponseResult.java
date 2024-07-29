package com.camellia.zoj.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: 阿庆
 * @date: 2024/7/27 上午10:38
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> implements Serializable {

    /**
     * 响应返回编码
     */
    @ApiModelProperty(value = "状态码")
    private int code;

    /**
     * 响应返回信息
     */
    @ApiModelProperty(value = "状态信息")
    private String msg;

    /**
     * 返回结果
     */
    @ApiModelProperty(value = "返回结果")
    private T data;


    public ResponseResult(HttpStatus httpStatus, T data) {
        this.code = httpStatus.getCode();
        this.msg = httpStatus.getMessage();
        this.data = data;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static <T> ResponseResult<T> success() {
        return ResponseResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static<T> ResponseResult<T> success(String msg) {
        return ResponseResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static<T> ResponseResult<T> success(String msg, T data) {
        return new ResponseResult(HttpStatus.SUCCESS.getCode(), msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static <T> ResponseResult<T> error() {
        return ResponseResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static <T> ResponseResult<T> error(String msg) {
        return ResponseResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static <T> ResponseResult<T> error(String msg, T data) {
        return new ResponseResult(HttpStatus.ERROR.getCode(), msg, data);
    }

    public static <T> ResponseResult<T> error(int code,String msg) {
        return new ResponseResult(code, msg);
    }

}
