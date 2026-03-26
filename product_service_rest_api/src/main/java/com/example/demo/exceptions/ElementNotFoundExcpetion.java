package com.example.demo.exceptions;

public class ElementNotFoundExcpetion extends RuntimeException {

	private String id;
	
	
	public ElementNotFoundExcpetion(String id) {
		super();
		this.id = id;
	}


	public String getId() {
		
		return this.id;
	}
}
