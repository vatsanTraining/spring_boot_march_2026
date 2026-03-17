package com.example.demo.ifaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.model.*;

public interface BookRepository {

	
	boolean add(Book book);
	
	Optional<Book> findbyId(int id) throws BookNotFoundException;
	
	List<Book> findAll();
	
}
