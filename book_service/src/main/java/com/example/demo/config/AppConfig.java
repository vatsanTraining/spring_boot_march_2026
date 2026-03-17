package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.ifaces.BookRepository;
import com.example.demo.implementations.BookRepositoryListImpl;
import com.example.demo.implementations.BookRepositorySetImpl;
import com.example.demo.model.Book;

@Configuration
public class AppConfig {

	
	@Bean
	Book javaOne() {
		
		return new Book(101, "Head First Java", "Sieera", 450);
	}
	
	@Bean
	Book javaTwo() {
		
		return new Book(102, "Thinking in Java", "Bruce", 350);
	}
	
	@Bean
	Book javaThree() {
		
		return new Book(103, "Effective Java", "Tom", 550);
	}
	
	@Bean
	Book javaFour() {
		
		return new Book(103, "Effective Java", "Tom", 550);
	}
	
	
	@Bean
	//@Primary
	BookRepository listRepo() {
		
		return new BookRepositoryListImpl();
	}
	
	@Bean
	BookRepository setRepo() {
		
		return new BookRepositorySetImpl();
	}
	
}
