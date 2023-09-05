package com.easy.admin.core.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenApiConfig
 *
 * @author tengchong
 * @date 2022/8/25
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI createOpenApiConfig() {
        return new OpenAPI()
                .info(new Info().title("Easy Boot API")
                        .description("Easy Boot API 使用文档")
                        .version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Easy Boot API")
                .pathsToMatch("/**")
                .build();
    }

}
