package com.example.demo.exceptions;

public class DuplicateValueException extends Exception {

	private static final long serialVersionUID = 1L;
	String message;
	public DuplicateValueException(String message) {
		super(message);
	}

}
