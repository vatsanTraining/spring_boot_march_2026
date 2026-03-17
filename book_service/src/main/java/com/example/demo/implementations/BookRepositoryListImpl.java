package com.example.demo.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.ifaces.BookRepository;
import com.example.demo.model.Book;

/*
 * LOW LEVEL MODULE - ONE 
 * THIS CAN BE SWAPPED
 */
public class BookRepositoryListImpl implements BookRepository {


	private List<Book> bookList;
	
	
	
	public BookRepositoryListImpl() {
		super();

		this.bookList = new ArrayList<>();
	}

	@Override
	public Optional<Book> findbyId(int id) throws BookNotFoundException {
		 return this.bookList.stream().filter(e -> e.getBookId() ==id).findFirst();
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return this.bookList;
	}

	@Override
	public boolean add(Book book) {
		// TODO Auto-generated method stub
		return this.bookList.add(book);
		
	}

}
