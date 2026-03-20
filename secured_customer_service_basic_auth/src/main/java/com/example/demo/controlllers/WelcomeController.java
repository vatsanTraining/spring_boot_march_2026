package com.example.demo.controlllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	
	@GetMapping(path = "/api/v1/info")
	public String getInfo() {
		
		return "Unsecured Endpoint";
	}
}
