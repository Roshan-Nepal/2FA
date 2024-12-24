package com.roshan.twofa.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI() {
        return new io.swagger.v3.oas.models.OpenAPI()
                .info(new Info()
                        .title("My Project's REST API")
                        .description("This is a description of  API.")
                        .version("v1")
                        .contact(new Contact()
                                .name("Roshan Nepal")
                                .email("roshan.nepal@gmail.com")
                                .url("random"))
                        .license(new License()
                                .name("API License")
                                .url("Asd")));
    }
}
