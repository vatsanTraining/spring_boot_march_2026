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
	ConfigurableApplicationContext	 ctx=SpringApplication.run(Batch3DataJpaProductServiceApplication.class, args);
	
	
		Product tv = ctx.getBean("tv",Product.class);
		Product printer = ctx.getBean("printer",Product.class);
				
				
				
		ProductService service = ctx.getBean(ProductService.class);
		
		service.save(printer);
		
		service.save(tv);
		
		service.save(tv);
		
		  // service.deleteById(3030);

		service.findAll().forEach(System.out::println);
	
		
		//System.out.println("Found Element:=>"+ service.findById(2030));
		
	
	}

}
