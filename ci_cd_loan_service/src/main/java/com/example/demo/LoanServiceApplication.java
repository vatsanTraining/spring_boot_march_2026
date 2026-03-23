package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.LoanApplication;
import com.example.demo.services.LoanApplicationService;

@SpringBootApplication
public class LoanServiceApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(LoanServiceApplication.class, args);
	
	
	    LoanApplicationService service =ctx.getBean(LoanApplicationService.class);
	    
	    var app1 =ctx.getBean("firstApplicant",LoanApplication.class);
	    
	    var app2 =ctx.getBean("secondApplicant",LoanApplication.class);
	    
	    
	    service.save(app1);
	    service.save(app2);
	    
	    
	    service.findAll().forEach(System.out::println);

	    System.out.println("Find Applicant By Name Ramesh");
	    
	    service.findByName("Ramesh").forEach(System.out::println);
	}

}

