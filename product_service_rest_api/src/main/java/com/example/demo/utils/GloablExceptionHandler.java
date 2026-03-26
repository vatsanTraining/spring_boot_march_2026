package com.example.demo.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
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

import com.example.demo.exceptions.ElementNotFoundExcpetion;

@RestControllerAdvice
public class GloablExceptionHandler {


	ReloadableResourceBundleMessageSource messageSource;
	 
	 
	public GloablExceptionHandler(ReloadableResourceBundleMessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>  handleValidationErrors(BindException ex,WebRequest req){
		
		Map<String,String> errors = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> 
		errors.put(error.getField(), error.getDefaultMessage())
		);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}

	@ExceptionHandler(exception =ElementNotFoundExcpetion.class)
	public ResponseEntity<Map<String, String>>  handleAll(ElementNotFoundExcpetion ex,
			 WebRequest req,Locale locale){
		
		
		Map<String,String> errors = new HashMap<>();
		
		Object[] args = new Object[]{ex.getId()};
		
		String message = messageSource.getMessage("element.notfound", args, locale);


		errors.put("cause", message);
		errors.put("time", LocalDateTime.now().toString());
		errors.put("url", req.getDescription(false));
		
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

