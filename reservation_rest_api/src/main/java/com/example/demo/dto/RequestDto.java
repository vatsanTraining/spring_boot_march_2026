package com.example.demo.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Positive;


public record RequestDto(Long id,@Length(min = 3,max = 15,message = "It should be 3 to 15 chars") 
String passengerName,@Future(message = "Date before the current Date") LocalDateTime bookingDate,
@Positive(message = "Amount should be positive") Double totalAmount,String status) {
 
	public RequestDto(Long id, String passengerName, LocalDateTime bookingDate, Double totalAmount, String status) {
	
		this.id = id;
		this.passengerName = passengerName;
		this.bookingDate = bookingDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	
}



