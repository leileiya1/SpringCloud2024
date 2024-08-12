package com.sapiece.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author SAPiece
 * @Create 2024-07-29 10:15
 * @Package com.sapiece.controller
 * @Project SpringCloud2024
 * @Filename PayCircuitController
 * @Version 1.0
 */
@RestController
public class PayCircuitController {
    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id) {
        if (id == -4) throw new RuntimeException("PayCircuit不能为负数");
        if (id == 9999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "hello circuit!inputId:" + id + "\t" + IdUtil.simpleUUID();
    }
}
