package com.sapiece.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author SAPiece
 * @Create 2024-08-02 23:41
 * @Package com.sapiece.controller
 * @Project SpringCloud2024
 * @Filename EmpowerController
 * @Version 1.0
 */
@RestController
@Slf4j
public class EmpowerController {
    @GetMapping("/empower")
    public String requestSentinel(){
        log.info("测试Sentinel授权规则empower");
        return "Sentinel授权规则";
    }
}
