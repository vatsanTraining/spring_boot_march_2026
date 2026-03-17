package com.example.demo.exceptions;

public class BookNotFoundException extends Exception {

	private String message;
	
	public BookNotFoundException(String message) {
		
		this.message = message;
	}

	public BookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	
}
