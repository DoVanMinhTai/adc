package com.example.book.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Book Web API",
                version = "1.0",
                description = "API documentation for Book Web"
        ),
        servers = {
                @Server(url = "/", description = "Default Server URL")
        }
)
public class SwaggerConfig {
}
