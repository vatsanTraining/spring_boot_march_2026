package com.example.demo.controlllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.exceptions.ElementNotFoundEception;
import com.example.demo.services.CustomerService;

import jakarta.validation.Valid;

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

	@GetMapping(path = "/{id}")
	ResponseEntity<Customer> findById(@PathVariable long id) throws ElementNotFoundEception{
		
		return ResponseEntity.ok().body(service.findById(id));
		
	}

	
	@PostMapping
	ResponseEntity<CustomerDto> save(@Valid @RequestBody CustomerDto dto){
		
		return ResponseEntity.status(201).body(service.save(dto));
	}
	
	
	@DeleteMapping(path = "/{id}")
	ResponseEntity<Void> deleteById(@PathVariable long id) throws ElementNotFoundEception{
		
		service.removeById(id);
		
		return ResponseEntity.noContent().build();
		
	}

	
	
}
