package com.example.demo.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = RuntimeException.class)
	public Map<String,String> handleRunTime(RuntimeException ex, WebRequest req,Locale locale){
		
		Map<String,String> errors = new HashMap<>();
		
		
		errors.put("cause",ex.getMessage());
		errors.put("url",req.getDescription(false));
		errors.put("time", LocalDateTime.now().toString());
		
		return errors;
	}
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>  handleValidationErrors(BindException ex,WebRequest req){
		
		Map<String,String> errors = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> 
		errors.put(error.getField(), error.getDefaultMessage())
		);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}

}
