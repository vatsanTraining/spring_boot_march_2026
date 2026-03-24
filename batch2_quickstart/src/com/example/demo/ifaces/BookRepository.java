package com.example.demo.ifaces;

import java.util.List;
import java.io.*;
import com.example.demo.Book;

public interface BookRepository {

	
	boolean writeToFile(File file,Book book);
	List<Book> readFromFile(File file);
}
