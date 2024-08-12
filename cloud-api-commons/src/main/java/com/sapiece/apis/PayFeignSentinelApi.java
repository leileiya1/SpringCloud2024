package com.sapiece.apis;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sapiece.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author SAPiece
 * @Create 2024-08-03 9:05
 * @Package com.sapiece.apis
 * @Project SpringCloud2024
 * @Filename PayFeignSentinelApi
 * @Version 1.0
 */
@FeignClient(value = "nacos-payment-provider",fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi {
    @GetMapping("/pay/nacos/get/{orderNo}")
    ResultData getPayByOrder(@PathVariable("orderNo") String orderNo);
}
