package com.sapiece;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author SAPiece
 * @Create 2024-07-18 17:16
 * @Package com.sapiece
 * @Project Default (Template) Project
 * @Filename ${NAME}
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main80 {
    public static void main(String[] args) {
        SpringApplication.run(Main80.class, args);
    }
}