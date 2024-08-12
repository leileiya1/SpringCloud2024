package com.sapiece.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author SAPiece
 * @Create 2024-07-18 13:35
 * @Package com.sapiece.resp
 * @Project SpringCloud2024
 * @Filename ResultData
 * @Version 1.0
 */
@Accessors(chain = true)
@Data
public class ResultData<T> {
    private String code;
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }
    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }
    public static <T> ResultData<T> failure(String code,String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }
}
