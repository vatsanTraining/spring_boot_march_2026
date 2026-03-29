package com.example.demo.exceptions;

public class ElementNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ElementNotFoundException(String string) {

		this.message = string;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
