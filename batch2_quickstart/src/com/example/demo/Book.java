package com.example.demo;

import com.example.demo.exceptions.RangeCheckException;

public class Book  {

	
	private int bookNumber;
	private String bookName;
	private String author;
	private double pricePerUnit;
	
	public Book() {
		super();
	}

	// Exception is checked Exception must  handle or declare

	public Book(int bookNumber, String bookName, String author, double pricePerUnit) throws RangeCheckException{
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.author = author;
		if(pricePerUnit <=0) {
			 throw new RangeCheckException("Price should not be a Zero or negative value");
			}
		  this.pricePerUnit = pricePerUnit;


	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
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

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	// RuntimeException is unchecked Exception no need handle nor declare
	public void setPricePerUnit(double pricePerUnit) {
		if(pricePerUnit <=0) {
			 throw new RuntimeException("Price should not be a Zero or negative value");
			}
		  this.pricePerUnit = pricePerUnit;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.bookNumber + ","+this.bookName+","+this.author +","+this.pricePerUnit;
	}
	
	
	
	
}
