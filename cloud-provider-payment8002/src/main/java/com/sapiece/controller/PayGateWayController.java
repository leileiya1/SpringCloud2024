package com.sapiece.controller;

import cn.hutool.core.util.IdUtil;
import com.sapiece.entities.Pay;
import com.sapiece.resp.ResultData;
import com.sapiece.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author SAPiece
 * @Create 2024-08-03 17:39
 * @Package com.sapiece.controller
 * @Project SpringCloud2024
 * @Filename PayGateWayController
 * @Version 1.0
 */
@RestController
public class PayGateWayController {
    @Resource
    PayService payService;
    @GetMapping("/pay/gateway/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id){
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }
    @GetMapping("/pay/gateway/info")
    public ResultData<String> getGatewayInfo(){
        return ResultData.success("gateway info test2"+ IdUtil.simpleUUID());
    }

}
