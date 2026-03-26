package com.example.demo.exceptions;

public class ElementNotFoundExcpetion extends RuntimeException {

	private String id;
	
	
	public ElementNotFoundExcpetion(String id) {
		super();
		this.id = id;
	}


	private String getId() {
		
		return this.id;
	}
}
