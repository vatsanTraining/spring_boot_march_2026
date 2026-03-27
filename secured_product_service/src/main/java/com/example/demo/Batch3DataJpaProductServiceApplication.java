package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo","org.training"})
@OpenAPIDefinition(info =
@Info(title = "Product Service", version = "1.0",description = "Rest API For Product Management"))
public class Batch3DataJpaProductServiceApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(Batch3DataJpaProductServiceApplication.class, args);
	
	
		}

}
