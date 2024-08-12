package com.sapiece;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @Author SAPiece
 * @Create 2024-07-18 9:15
 * @Package com.sapiece
 * @Project Default (Template) Project
 * @Filename ${NAME}
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@MapperScan("com.sapiece.mapper")
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }
}