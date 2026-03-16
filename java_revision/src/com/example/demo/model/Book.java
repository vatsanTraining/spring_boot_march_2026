package com.example.demo.model;

import java.util.Objects;

/**
 * @author srivatsan
 * @version 1.0
 * Demo Done During Spring Boot Training
 * Class is Encapsulated
 */

public class Book {

	
	private int bookId;
	private String bookName;
	private String author;
	private double price;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String bookName, String author, double price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(author, bookId, bookName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && bookId == other.bookId
				&& Objects.equals(bookName, other.bookName)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return  this.bookName+","+this.author;
	}
	
	
	
	
}
