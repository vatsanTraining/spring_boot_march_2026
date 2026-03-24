package com.example.demo.exceptions;

public class RangeCheckException extends Exception {

	
	
	
	private static final long serialVersionUID = 1L;
	

	
	public RangeCheckException(String message, Throwable cause) {
		super(message, cause);
	}

	public RangeCheckException(String message) {
		super(message);
	}
	
	
	
	
	
}
