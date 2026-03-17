package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx=SpringApplication.run(BookServiceApplication.class, args);
	
		
		System.out.println(ctx.getBean("java"));
		
		
	     ctx.close();
	
	}

}
