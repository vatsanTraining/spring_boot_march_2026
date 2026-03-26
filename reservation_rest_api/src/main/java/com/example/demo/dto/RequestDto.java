package com.example.demo.dto;

import java.time.LocalDateTime;

public record RequestDto(Long id,String passengerName,LocalDateTime bookingDate,double totalAmount,String status) {
 
	public RequestDto(Long id, String passengerName, LocalDateTime bookingDate, double totalAmount, String status) {
		this.id = id;
		this.passengerName = passengerName;
		this.bookingDate = bookingDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	
}
