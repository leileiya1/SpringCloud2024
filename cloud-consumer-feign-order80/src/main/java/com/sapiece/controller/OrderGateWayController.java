package com.sapiece.controller;

import com.sapiece.apis.FeignApi;
import com.sapiece.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author SAPiece
 * @Create 2024-08-05 15:21
 * @Package com.sapiece.controller
 * @Project SpringCloud2024
 * @Filename OrderGateWayController
 * @Version 1.0
 */
@RestController
@RequestMapping("/feign")
public class OrderGateWayController {
    @Resource
    private FeignApi payFeignApi;
    @GetMapping("/pay/gateway/get/{id}")
    ResultData getById(@PathVariable("id") Integer id){
        return payFeignApi.getById(id);
    }

    @GetMapping("/pay/gateway/info")
    ResultData<String> getGatewayInfo(){
        return payFeignApi.getGatewayInfo();
    }
}
