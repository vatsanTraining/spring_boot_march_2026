package com.example.demo.exceptions;

public class ElementNotFoundEception extends Exception {

	private Long id;

	
	public ElementNotFoundEception(Long id) {
		super();
		this.id = id;
	}

	
	public Long getId() {
		return id;
	}

	
	
	
	
}
