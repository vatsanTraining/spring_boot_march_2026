package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Batch3ProductServiceApplication {

	public static void main(String[] args) {
		
		// ctx is the representation of IoC container
		
		ConfigurableApplicationContext ctx= SpringApplication.run(Batch3ProductServiceApplication.class, args);
	}

}
