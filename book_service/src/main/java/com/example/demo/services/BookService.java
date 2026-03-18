package com.example.demo.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.ifaces.BookRepository;
import com.example.demo.model.Book;

/*
 * HIGH LEVEL MODULE  
 * A PARTICULAR IMPLEMENTATION OF BOOK REPOSITORY WILL BE INJECTED AT RUN TIME
 */

@Service
public class BookService {

	
	private BookRepository repo;

	


	//@Autowired
	/*
	 * @Autowired is un-nessary , since this class has one and only
	 * constructor so it will be auto wired, if there are more than 
	 * constructor then we can add @AutoWired
	 */
	public BookService(@Qualifier("listRepo") BookRepository repo) {
		super();
		this.repo = repo;
		
		// System.out.println(this.repo.getClass().getName());
	}



	public boolean add(Book book) {
		
		return this.repo.add(book);
	}
	
	public Book findById(int id) throws BookNotFoundException {
		
		return this.repo.findbyId(id).orElseThrow(() -> new BookNotFoundException("Element with Given Id Not Found"));
	}
	
	public Collection<Book> findAll(){
		
		return this.repo.findAll();
	}
	
}
