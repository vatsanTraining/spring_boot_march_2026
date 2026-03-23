package com.example.demo.controlllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.exceptions.DuplicateValueException;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/api/v1/auth")
public class LoginController {

	 private UserServiceImpl userService; 
	    
	    
	    

	    public LoginController(UserServiceImpl userService) {
			super();
			this.userService = userService;
		}
	
	    @PostMapping("/register")
	    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterRequest request) throws DuplicateValueException {
	        userService.registerNewUser(request); 
	        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
	    }
}
