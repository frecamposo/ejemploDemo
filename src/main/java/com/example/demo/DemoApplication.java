package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public OpenAPI customerOpenAPI(){
		return new OpenAPI()
		.info(new io.swagger.v3.oas.models.info.Info()
		.title("API EcoMarket")
		.version("V1")
		.description("Creacion de EndPoint de Ecomarket")
		);
	}
}
