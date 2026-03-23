package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.model.LoanApplication;
import com.example.demo.repos.LoanApplicationRepository;

@Configuration
public class AppConfig {

	
	@Bean
	LoanApplication firstApplicant() {

		return new LoanApplication(202, "Ramesh", 500000, "AB123PS");
	}
	
	@Bean
	LoanApplication secondApplicant() {
		
		return new LoanApplication(203, "Suresh", 600000, "PB123PS");
	}
	
	
	
		
}
