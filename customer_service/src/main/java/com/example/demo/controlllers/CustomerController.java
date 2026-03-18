package com.example.demo.controlllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerService;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

	
	
	private CustomerService service;

	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	ResponseEntity<List<Customer>> findAll(){
		
		return ResponseEntity.ok().body(service.findAll());
		
	}
	
	
	@PostMapping
	ResponseEntity<CustomerDto> save(@RequestBody CustomerDto dto){
		
		return ResponseEntity.status(201).body(service.save(dto));
	}
	
}
