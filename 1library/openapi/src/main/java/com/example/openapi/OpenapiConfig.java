package com.example.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author oizehsgl
 * @since 7/10/23
 */
@Configuration
public class OpenapiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info().title("测试openapi")
                .version("1.0")
                .description("openapi测试")
                .termsOfService("https://company.com/term")
                .license(
                        new License().name("xxLicense")
                                .url("https://license.com")
                )
                .contact(
                        new Contact().name("company")
                                .email("company@gmail.com")
                                .url("https://company.com")
                );

        List<Server> serverList = List.of(
                new Server().description("development").url("http://localhost:8080"),
                new Server().description("production").url("http://127.0.0.1:8080")
        );
        return new OpenAPI().info(info).servers(serverList);
    }
}
