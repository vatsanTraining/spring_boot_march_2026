package com.example.demo;
import java.util.*;
import com.example.demo.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.entity.Catalogue;
import com.example.demo.ifaces.CatalogueRepository;

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
	
	
	@Bean
	CommandLineRunner runner() {
		
		
		return new CommandLineRunner() {
			
			@Autowired
			CatalogueRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
				
				
				Catalogue myCatalogue = new Catalogue();
				myCatalogue.setId(101);
				myCatalogue.setDescription("Electronics 2024");
			
				List<Product> items = new ArrayList<>();
				items.add(new Product(1, "Laptop", "computer", 1200.00));
				items.add(new Product(2, "Mouse", "Accessories", 25.00));
			
				myCatalogue.setProducts(items); 
				repo.save(myCatalogue); 

			}
		};
	}

}
