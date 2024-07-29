package com.camellia.zoj.exception;

import com.camellia.zoj.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: 阿庆
 * @date: 2024/7/27 下午3:55
 * 全局异常类
 */

@RestControllerAdvice
@Slf4j
public class GlobalException {
    @ExceptionHandler
    public ResponseResult exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());

        return ResponseResult.error(ex.getCode(),ex.getMessage());
    }

    /**
     * 处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException", e);
        return ResponseResult.error("其他错误");
    }
}
