package com.sapiece.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author SAPiece
 * @Create 2024-08-05 14:48
 * @Package com.sapiece.apis
 * @Project SpringCloud2024
 * @Filename PayFeignClient
 * @Version 1.0
 */
@FeignClient("cloud-payment-service")
public interface PayFeignClient {
    @RequestMapping("/pay/get/info")
    String getPort();
}
