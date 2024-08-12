package com.sapiece.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author SAPiece
 * @Create 2024-07-18 12:55
 * @Package com.sapiece.config
 * @Project SpringCloud2024
 * @Filename Swagger3Config
 * @Version 1.0
 */
@Configuration
public class Swagger3Config {
    @Bean
    public GroupedOpenApi PayApi() {
        return GroupedOpenApi.builder()
                .group("支付服务模块")
                .pathsToMatch("/payment/**")
                .build();
    }

    @Bean
    public GroupedOpenApi OtherApi() {
        return GroupedOpenApi.builder()
                .group("其他服务模块")
                .pathsToMatch("/other/**", "/others")
                .build();
    }

    @Bean
    public OpenAPI docsOpenAPI() {
        return new OpenAPI().info(new Info().title("cloud2024")
                        .description("SpringCloud2024 支付服务模块")
                        .version("1.0.0"))
                .externalDocs(new ExternalDocumentation().description("www.sapiece.com")
                        .url("https://www.sapiece.com"));
    }
}
