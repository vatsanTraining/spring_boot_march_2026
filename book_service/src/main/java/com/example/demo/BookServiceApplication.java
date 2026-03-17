package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Book;
import com.example.demo.services.BookService;


@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		
		/*
		 * First Argument to the run method is a Java class annotated
		 * @SpringBootApplication
		 * the primary source should be java class with @SpringBootApplication
		 * 
		 */
		//ConfigurableApplicationContext ctx=SpringApplication.run(BookServiceApplication.class, args);
	
		
		SpringApplication app = new SpringApplication(BookServiceApplication.class);
		
		 app.setWebApplicationType(WebApplicationType.NONE);
		 
		 ConfigurableApplicationContext ctx=app.run(args);
		
		
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
