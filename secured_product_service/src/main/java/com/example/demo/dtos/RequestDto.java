package com.example.demo.dtos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Positive;

public record RequestDto(@Range(min=10,max=10000) int productId, 
		@Length(min=3,max=30) String productName, 
		String category,
		@Positive double ratePerUnit) {

	   public RequestDto(int productId, String productName, String category, double ratePerUnit) {
	        this.productId = productId;
	        this.productName = productName;
	        this.category = category;
	        this.ratePerUnit = ratePerUnit;
	    }
}
