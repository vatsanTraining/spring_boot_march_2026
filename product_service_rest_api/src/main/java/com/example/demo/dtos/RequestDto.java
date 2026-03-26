package com.example.demo.dtos;

public record RequestDto(int productId,String productName,String category,double ratePerUnit) {

	   public RequestDto(int productId, String productName, String category, double ratePerUnit) {
	        this.productId = productId;
	        this.productName = productName;
	        this.category = category;
	        this.ratePerUnit = ratePerUnit;
	    }
}
