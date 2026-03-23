package com.example.demo.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.exceptions.DuplicateValueException;
import com.example.demo.exceptions.ElementNotFoundException;
import com.example.demo.model.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@Autowired
	MessageSource messageSource;
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleValidationErrors(BindException ex, WebRequest request)
{

		Map<String,String> errors = new HashMap<>();

	     ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage())
	    );

	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
		
		
		}
	
	@ExceptionHandler(ElementNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleNotFoundException(ElementNotFoundException ex,Locale locale, WebRequest req){
		
		       Object[] args = new Object[]{ex.getId()};
		         
		       String message = messageSource.getMessage("element.notfound", args, locale);

		       req.getDescription(false);

		       ErrorInfo error =new ErrorInfo(LocalDateTime.now(),message,req.getDescription(false)); 

			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

		       
		       
	}
	
	@ExceptionHandler(DuplicateValueException.class)
    public ResponseEntity<Map<String, Object>> handleUserConflict(DuplicateValueException ex) {
		
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("status", HttpStatus.CONFLICT.value());
        body.put("error", "Conflict");

        return new ResponseEntity<>(body, HttpStatus.CONFLICT); 
    }
}
