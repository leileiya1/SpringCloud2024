package com.sapiece;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author SAPiece
 * @Create 2024-07-21 16:30
 * @Package com.sapiece
 * @Project Default (Template) Project
 * @Filename ${NAME}
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main9001 {
    public static void main(String[] args) {
        SpringApplication.run(Main9001.class, args);
    }
}