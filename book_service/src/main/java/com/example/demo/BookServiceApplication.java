package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Book;
import com.example.demo.services.BookService;

@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx=SpringApplication.run(BookServiceApplication.class, args);
	
		
		System.out.println(ctx.getBean("javaOne"));

		BookService service = ctx.getBean(BookService.class);

		service.add(ctx.getBean("javaOne",Book.class));
		service.add(ctx.getBean("javaTwo",Book.class));
		service.add(ctx.getBean("javaThree",Book.class));
		service.add(ctx.getBean("javaFour",Book.class));

		System.out.println("Printing ====");

		service.findAll().forEach(System.out::println);
		
		
		
		
		
		
		
	     ctx.close();
	
	}

}
