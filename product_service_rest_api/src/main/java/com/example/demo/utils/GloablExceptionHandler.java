package com.example.demo.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
/**
 * 	try {
			
		} catch (NullPointerException e) {
			// TODO: handle exception
		}catch(Exception e) {
			
		}
	
 */
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GloablExceptionHandler {

	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>  handleValidationErrors(BindException ex,WebRequest req){
		
		Map<String,String> errors = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> 
		errors.put(error.getField(), error.getDefaultMessage())
		);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}
	
	@ExceptionHandler(exception =Exception.class)
	public ResponseEntity<Map<String, String>>  handleAll(Exception ex, WebRequest req){
		
		
		Map<String,String> errors = new HashMap<>();

		errors.put("cause", ex.getMessage());
		errors.put("time", LocalDateTime.now().toString());
		errors.put("url", req.getDescription(false));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

		
	}
	
	
}

