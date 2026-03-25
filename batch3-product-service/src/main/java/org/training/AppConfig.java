package org.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Product;

@Configuration
public class AppConfig {

	
	
	@Bean
	Product  printer() throws Exception {
		
		return new Product(3030,"Epson", "printer", 15000);
		

	}
	

	@Bean
	Product  tv() throws Exception {
		
		return new Product(2030,"Sony Tv", "tv", 25000);
		

	}

}
