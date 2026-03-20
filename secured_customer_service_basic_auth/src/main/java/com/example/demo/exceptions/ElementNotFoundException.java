package com.example.demo.exceptions;

public class ElementNotFoundException extends Exception {

	private Long id;

	
	public ElementNotFoundException(Long id) {
		super();
		this.id = id;
	}

	
	public Long getId() {
		return id;
	}

	
	
	
	
}
