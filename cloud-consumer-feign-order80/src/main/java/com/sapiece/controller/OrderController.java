package com.sapiece.controller;

import com.sapiece.apis.FeignApi;

import com.sapiece.entities.PayDTO;
import com.sapiece.resp.ResultData;
import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author SAPiece
 * @Create 2024-07-18 17:37
 * @Package com.sapiece.controller
 * @Project SpringCloud2024
 * @Filename OrderController
 * @Version 1.0
 */
@RestController
@RequestMapping("/feign")
public class OrderController {
    @Autowired
    FeignApi payFeignApi;

    @PostMapping("/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {

        System.out.println("第一步,模拟本地addOrder新增订单成功,第二步开启addPayFeignApi调用支付服务接口");
        return payFeignApi.addPay(payDTO);
    }

    @GetMapping("/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        System.out.println("第一步,模拟本地getPayInfo查询订单成功,第二步开启getPayFeignApi调用支付服务接口");
        return payFeignApi.queryPay(id);
    }

    @GetMapping("/pay/get/info")
    public String loadBalance() {
        System.out.println("第一步,模拟本地loadBalance查询负载均衡成功,第二步开启getInfoFeignApi调用支付服务接口");
        return payFeignApi.getInfo();
    }
}
