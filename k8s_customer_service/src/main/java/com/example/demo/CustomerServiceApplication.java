package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.example.demo.entity.Customer;
import com.example.demo.ifaces.CustomerRepository;
import com.example.demo.services.CustomerService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Customer Management App",version = "1.0"))
public class CustomerServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(CustomerServiceApplication.class, args);
	
		
		
		CustomerService service = ctx.getBean(CustomerService.class);
		
		   service.findAll().forEach(System.out::println);
		   
		System.out.println("Find By Name:=>"+ service.findByCustomerName("Vishwa"));
		
		
		System.out.println("Find By Phone Number:=>"+ service.findByPhone(8928244L));
		
	
		//ctx.close();
	}

	@Bean
	ReloadableResourceBundleMessageSource messageSouce() {
		
	ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
	
	source.setBasename("classpath:message");
	source.setDefaultEncoding("UTF-8");
	
	return source;
	
	}

	
	@Bean
	CommandLineRunner runner() {
		
		
		return new CommandLineRunner() {
			
			@Autowired
			CustomerRepository repo;
			@Override
			public void run(String... args) throws Exception {
				repo.deleteAll();
				repo.save(new Customer(1111L, "Tom", 7888233, "tom@abc.com"));
				repo.save(new Customer(2222L, "Dick", 3455902, "dick@abc.com"));
				
			}
		};
	}
}
