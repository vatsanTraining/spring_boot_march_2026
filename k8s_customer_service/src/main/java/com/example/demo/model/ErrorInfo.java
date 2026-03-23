package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;

public class ErrorInfo  {

	private LocalDateTime dateTime;
	private String message;
	private String description;
	public ErrorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorInfo(LocalDateTime dateTime, String message, String description) {
		super();
		this.dateTime = dateTime;
		this.message = message;
		this.description = description;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ErrorInfo [dateTime=" + dateTime + ", message=" + message + ", description=" + description + "]";
	}
	
	
	
}
