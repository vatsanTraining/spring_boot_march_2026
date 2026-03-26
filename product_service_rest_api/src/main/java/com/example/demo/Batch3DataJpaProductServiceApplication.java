package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.services.ProductService;
import com.example.demo.entity.*;
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo","org.training"})
public class Batch3DataJpaProductServiceApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(Batch3DataJpaProductServiceApplication.class, args);
	
	
		}

}
