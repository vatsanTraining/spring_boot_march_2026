package com.example.demo.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
public record CustomerDto(@Positive Long customerId,@Length(max = 30,min=3,message="Customer Name should be 3 to 30 chars" ) String customerName,@Email(message = "Enter the Personal Mail") String email,long phoneNumber) {

	
	 public CustomerDto(Long customerId, String customerName, String email, long phoneNumber){
		 	this.customerId = customerId;
	        this.customerName = customerName;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	 }
}
