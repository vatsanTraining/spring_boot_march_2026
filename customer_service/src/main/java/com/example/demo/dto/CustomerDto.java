package com.example.demo.dto;

public record CustomerDto(Long customerId,String customerName,String email,long phoneNumber) {

	
	 public CustomerDto(Long customerId, String customerName, String email, long phoneNumber){
		 	this.customerId = customerId;
	        this.customerName = customerName;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	 }
}
