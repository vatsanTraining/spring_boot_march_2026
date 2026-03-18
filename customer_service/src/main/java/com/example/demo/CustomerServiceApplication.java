package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Customer;
import com.example.demo.ifaces.CustomerRepository;
import com.example.demo.services.CustomerService;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(CustomerServiceApplication.class, args);
	
		ctx.getBean(CustomerService.class)
		  .findAll()
		  .forEach(System.out::println);
		
		
		CustomerService service = ctx.getBean(CustomerService.class);
		
		
		System.out.println("Find By Name:=>"+ service.findByCustomerName("Vishwa"));
		
		
		System.out.println("Find By Phone Number:=>"+ service.findByPhone(8928244L));
		
	
		ctx.close();
	}

	
	@Bean
	CommandLineRunner runner() {
		
		
		return new CommandLineRunner() {
			
			@Autowired
			CustomerRepository repo;
			@Override
			public void run(String... args) throws Exception {
				
				repo.save(new Customer(1000L, "Siva", 7888233, "siva@abc.com"));
				repo.save(new Customer(2000L, "Vishwa", 8928244, "viswa@abc.com"));
				
			}
		};
	}
}
