package com.sapiece.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author SAPiece
 * @Create 2024-07-18 17:35
 * @Package com.sapiece.config
 * @Project SpringCloud2024
 * @Filename RestTemplateConfig
 * @Version 1.0
 */
@Configuration
public class RestTemplateConfig
{
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
