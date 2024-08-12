package com.sapiece.controller;

import com.sapiece.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author SAPiece
 * @Create 2024-08-01 9:30
 * @Package com.sapiece
 * @Project SpringCloud2024
 * @Filename FlowLimitController
 * @Version 1.0
 */
@RestController
public class FlowLimitController {
    @Resource
    private FlowLimitService flowLimitService;
    @GetMapping("/testA")
    public String testA() {
        return "----------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "---------testB";
    }
    @GetMapping("/testC")
    public String testC() {
        flowLimitService.common();
        return "----------testC";
    }

    @GetMapping("/testD")
    public String testD() {
        flowLimitService.common();
        return "---------testD";
    }
    @GetMapping("/testF")
    public String testF() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---测试:新增熔断规则-慢调用比列");
        return "----------testF 新增熔断规则-慢调用比列";
    }

}
