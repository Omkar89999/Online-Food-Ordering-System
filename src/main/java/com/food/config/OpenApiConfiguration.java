package com.food.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI openApi() {
        // Define the security requirement using the security scheme name
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerScheme");

        return new OpenAPI()
            .addSecurityItem(securityRequirement) // Apply the security requirement globally
            .components(new Components()
                .addSecuritySchemes("bearerScheme", // Define the security scheme
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")))
            .info(new Info()
                .title("Backend Online Food Ordering API")
                .description("This is a Food app API project developed by Team Adesh & Om")
                .version("1.0")
                .contact(new Contact()
                    .name("Omkar")
                    .email("omkarghodechor89@gmail.com")
                    .url(""))
                .license(new License()
                    .name("Apache")
                    .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
