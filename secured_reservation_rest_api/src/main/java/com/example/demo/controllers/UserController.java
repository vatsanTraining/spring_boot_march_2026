package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.WebUserDto;

@RestController
@RequestMapping(path = "/api/v1/auth/")
public class UserController {

	
	
	
	@GetMapping(path = "info")
	public ResponseEntity<String> info(){
		
		return ResponseEntity.ok("Unsecured End point");
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<String> register(WebUserDto dto){
		
		//TODO
		return ResponseEntity.ok("will make this secured End point");
	}
}
