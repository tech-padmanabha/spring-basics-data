package io.pn.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// It will replace default OpenAPI definition v0  OAS 3.0
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Pointersnib Swagger Docs")                )
@Configuration
public class SwaggerOpenApiConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(
                  new Info()
                        .title("Spring Boot Swagger API")
                        .version("1.0.0")
                        .description("API documentation for Spring Boot application"));
    }
}
