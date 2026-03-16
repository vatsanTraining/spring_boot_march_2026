package com.example.demo.services;

import java.util.List;

import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.ifaces.BookRepository;
import com.example.demo.model.Book;

public class BookService {

	
	private BookRepository repo;

	
	
	
	public BookService(BookRepository repo) {
		super();
		this.repo = repo;
	}



	public boolean add(Book book) {
		
		return this.repo.add(book);
	}
	
	public Book findById(int id) throws BookNotFoundException {
		
		return this.repo.findbyId(id).orElseThrow(() -> new BookNotFoundException("Element with Given Id Not Found"));
	}
	
	public List<Book> findAll(){
		
		return this.repo.findAll();
	}
	
}
