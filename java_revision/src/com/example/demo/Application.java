package com.example.demo;

import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.ifaces.BookRepository;
import com.example.demo.implementations.BookRepositoryImpl;
import com.example.demo.model.Book;
import com.example.demo.services.BookService;

public class Application {

	public static void main(String[] args) {
		
		
		Book headFirstJava = 
				new  Book(101, "Head First Java", "kathy sieera", 450);
		

		Book headFirstJava2 = 
				new  Book(101, "Head First Java", "kathy sieera", 450);

		
		Book thinkingInJava = 
				new  Book(103, "Thinking in Java", "Bruce Erickel", 550);
		
		
		Book effectiveJava = 
				new  Book(102, "Effective Java", "author", 350);
		
		// supertype = subtype is always valid
		// subtype = (subtype)supertype  needs casting
		// typeA = typeB  is never valid unrelated types 
		
		// polymorphism
		
		BookRepository repo = new BookRepositoryImpl();
		
		BookService service = new BookService(repo);
		
		
		System.out.println("Is Added :=>"+ service.add(effectiveJava));
		
		System.out.println("Is Added :=>"+ service.add(thinkingInJava));
		
		System.out.println("Is Added :=>"+ service.add(headFirstJava));
		
		
		service.findAll().forEach((e) -> System.out.println(e)) ;
		
		
		// Fix It
		
		System.out.println("Is Equal:=>"+ headFirstJava.equals(headFirstJava2));
		
		
	
	try {
		System.out.println(service.findById(102));
		
		System.out.println(service.findById(202));

	} catch (BookNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		
	}
	
}
