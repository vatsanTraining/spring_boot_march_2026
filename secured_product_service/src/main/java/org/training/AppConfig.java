package org.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.example.demo.entity.Product;

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
	
	@Bean
	ReloadableResourceBundleMessageSource messageSource() {
		
		ReloadableResourceBundleMessageSource obj = new ReloadableResourceBundleMessageSource();
		
		obj.setDefaultEncoding("UTF-8");
		obj.addBasenames("classpath:message");
		
		return obj;
	}

}
