package com.sapiece;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author SAPiece
 * @Create 2024-07-23 14:59
 * @Package com.sapiece
 * @Project Default (Template) Project
 * @Filename ${NAME}
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MainOpenFeign8008 {
    public static void main(String[] args) {
        SpringApplication.run(MainOpenFeign8008.class, args);
    }
}