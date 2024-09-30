package com.local.ms_order.application.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderSwaggerConfig {
    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("Order - group")
                .pathsToMatch("/**")
                .displayName("Order API")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().version("1.0")
                .description("Order api para el trato de las pedidos sea de venta o de encargo")
                        .summary("Order API")
                .contact(new Contact().email("noj2304@gmail.com")
                        .name("Jhoan Olivo")
                ).title("Order API"));

    }
}
