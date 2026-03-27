package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth/")
public class UserController {

	
	
	
	@GetMapping(path = "info")
	public ResponseEntity<String> info(){
		
		return ResponseEntity.ok("Unsecured End point");
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<String> register(){
		
		//TODO
		return ResponseEntity.ok("will make this secured End point");
	}
}
