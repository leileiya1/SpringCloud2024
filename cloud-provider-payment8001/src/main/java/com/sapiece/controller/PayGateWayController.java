package com.sapiece.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.sapiece.entities.Pay;
import com.sapiece.resp.ResultData;
import com.sapiece.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

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
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping("/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return ResultData.success("gateway info test1" + IdUtil.simpleUUID());
    }

    @GetMapping("/pay/gateway/filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request) {
        String result = "";
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headName = headers.nextElement();
            String headerValue = request.getHeader(headName);
            System.out.println("请求头名:" + headName + "\t\t\t" + "请求头值:" + headerValue);
            if (headName.equalsIgnoreCase("X-Request-sapiece") ||
                    headName.equalsIgnoreCase("X-request-leilei")) {
                result = result + headName + "\t" + headerValue + " ";

            }
        }
        return ResultData.success("gateway过滤器 test:" + result + "\t" + DateUtil.now());

    }

}
