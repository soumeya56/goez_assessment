package com.TravelSmileApp.GoEz.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

public class OpenApiConfig {
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Technical Assessment For GoEz").description(
                        "Documentations related to Technical Assessment for GoEz."));
    }
	
	//to generate swagger documentation http://localhost:8080/swagger-ui.html

}
