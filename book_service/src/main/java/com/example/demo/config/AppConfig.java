package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Book;

@Configuration
public class AppConfig {

	
	@Bean
	Book java() {
		
		return new Book(101, "Head First Java", "Sieera", 450);
	}
	
}
