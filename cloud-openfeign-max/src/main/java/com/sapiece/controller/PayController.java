package com.sapiece.controller;

import com.sapiece.apis.PayFeignClient;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author SAPiece
 * @Create 2024-08-05 14:50
 * @Package com.sapiece.controller
 * @Project SpringCloud2024
 * @Filename PayController
 * @Version 1.0
 */
@RestController
@RequestMapping("/feign")
public class PayController {
    @Resource
    private PayFeignClient payFeignClient;
    @RequestMapping("/pay/get/info")
    public String getPort(){
        return payFeignClient.getPort();
    }
}
