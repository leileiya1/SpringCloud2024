package com.sapiece.exception;

import com.sapiece.resp.ResultData;
import com.sapiece.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author SAPiece
 * @Create 2024-07-18 16:41
 * @Package com.sapiece.exception
 * @Project SpringCloud2024
 * @Filename GlobalExceptionHandler
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exceptionHandler(Exception e) {
        log.error("服务器内部错误:{}", e.getMessage(),e);
        return ResultData.failure(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
