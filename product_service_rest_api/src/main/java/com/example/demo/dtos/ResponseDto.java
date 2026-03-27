package com.example.demo.dtos;


public record ResponseDto(String productName, 
		String category,
		double ratePerUnit) {

	 public ResponseDto(String productName, String category, double ratePerUnit) {
	        this.productName = productName;
	        this.category = category;
	        this.ratePerUnit = ratePerUnit;
	    }
}
