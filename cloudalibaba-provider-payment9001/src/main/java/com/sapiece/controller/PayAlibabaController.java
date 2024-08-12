package com.sapiece.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sapiece.entities.PayDTO;
import com.sapiece.resp.ResultData;
import com.sapiece.resp.ReturnCodeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author SAPiece
 * @Create 2024-07-21 16:40
 * @Package com.sapiece.controller
 * @Project SpringCloud2024
 * @Filename PayAlibabaController
 * @Version 1.0
 */
@RestController
@RequestMapping("/pay")
public class PayAlibabaController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/nacos/{id}")
    public String getPayInfo(@PathVariable("id") Integer id){
        return "This is Alibaba payment service, port is " + port + ", id is " + id;
    }
    @GetMapping("/pay/nacos/get/{orderNo}")
    @SentinelResource(value = "getPayByOrder", blockHandler = "handlerBlockHandler")
    public ResultData getPayByOrder(@PathVariable("orderNo") String orderNo){
        PayDTO payDTO = new PayDTO();
        payDTO.setId(1008);
        payDTO.setOrderNo(orderNo);
        payDTO.setAmount(BigDecimal.valueOf(9.9));
        payDTO.setPayNo("pay:"+ IdUtil.fastUUID());
        payDTO.setUserId(2599);
        return ResultData.success(payDTO);
    }
    public ResultData handlerBlockHandler(BlockException ex) {
        return ResultData.failure(ReturnCodeEnum.RC500.getCode(), "getPayByOrder服务不可用，请稍后再试,"+
    "触发了流控规则，请稍后再试");
    }
}
