package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.services.ProductService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo","org.training"})
public class Batch3ProductServiceApplication {

	public static void main(String[] args) {
		
		// ctx is the representation of IoC container
		
		ConfigurableApplicationContext ctx= SpringApplication.run(Batch3ProductServiceApplication.class, args);
	
		
		Product tv = ctx.getBean("tv",Product.class);
		Product printer = ctx.getBean("printer",Product.class);
				
				
				
		ProductService service = ctx.getBean(ProductService.class);
		
		service.save(printer);
		
		service.save(tv);
		
		service.save(tv);
		
		service.findAll().forEach(System.out::println);
	
	}

}
