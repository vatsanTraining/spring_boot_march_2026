package com.example.demo.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
}
