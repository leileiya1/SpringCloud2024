package com.sapiece.apis;

import com.sapiece.resp.ResultData;
import com.sapiece.resp.ReturnCodeEnum;

/**
 * @Author SAPiece
 * @Create 2024-08-03 9:08
 * @Package com.sapiece.apis
 * @Project SpringCloud2024
 * @Filename PayFeignSentinelApiFallBack
 * @Version 1.0
 */
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {
    @Override
    public ResultData getPayByOrder(String orderNo) {
        return ResultData.failure(ReturnCodeEnum.RC500.getCode(), "对方服务暂时不可用，请稍后再试o(╥﹏╥)o" );
    }
}
