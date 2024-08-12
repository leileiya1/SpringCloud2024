package com.sapiece.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Author SAPiece
 * @Create 2024-08-01 9:50
 * @Package com.sapiece.service
 * @Project SpringCloud2024
 * @Filename FlowLimitService
 * @Version 1.0
 */
@Service
public class FlowLimitService {
    @SentinelResource(value = "common")
    public void common() {
        System.out.println("-----FlowLimitService.common in");
    }

}
