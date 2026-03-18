package com.example.demo.implementations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.ifaces.BookRepository;
import com.example.demo.model.Book;

/*
 * LOW LEVEL MODULE - TWO 
 * THIS CAN BE SWAPPED
 */

public class BookRepositorySetImpl implements BookRepository {


	private Set<Book> bookList;
	
	
	
	public BookRepositorySetImpl() {
		super();

		this.bookList = new HashSet<>();
	}

	@Override
	public Optional<Book> findbyId(int id) throws BookNotFoundException {
		 return this.bookList.stream().filter(e -> e.getBookId() ==id).findFirst();
	}

	@Override
	public Set<Book> findAll() {
		// TODO Auto-generated method stub
		return this.bookList;
	}

	@Override
	public boolean add(Book book) {
		// TODO Auto-generated method stub
		return this.bookList.add(book);
		
	}

}
