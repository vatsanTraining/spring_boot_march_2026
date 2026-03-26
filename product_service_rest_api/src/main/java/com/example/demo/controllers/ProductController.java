package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.RequestDto;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

	
	private ProductService service;

	public ProductController(ProductService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<RequestDto> save(@RequestBody RequestDto dto) throws Exception{
		
		return ResponseEntity.status(201).body(this.service.save(dto));
		
	}

	@GetMapping
	public ResponseEntity<List<RequestDto>> findAll(){
		
		return ResponseEntity.status(200).body(this.service.findAll());
	}
	

	@GetMapping(path = "/{id}")
	public ResponseEntity<RequestDto> findById(@PathVariable int id ){
		
		return ResponseEntity.ok(this.service.findById(id));
	}
	
	@PatchMapping
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> DeleteById(@PathVariable int id ){
		
		this.service.deleteById(id);
		
		return ResponseEntity.noContent().build() ;  // return status code 204
	}
	
	
}
