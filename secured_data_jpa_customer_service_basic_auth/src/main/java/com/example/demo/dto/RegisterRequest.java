package com.example.demo.dto;

import org.hibernate.validator.constraints.*;

import jakarta.validation.constraints.Email;

public record RegisterRequest(@Length(min = 3,max=10, message="user name 3 to 10 chars") String username, 
		@Email String email, String password,String role) {
 

}
