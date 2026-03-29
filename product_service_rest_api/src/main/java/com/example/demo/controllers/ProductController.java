package com.example.demo.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.RequestDto;
import com.example.demo.dtos.ResponseDto;
import com.example.demo.exceptions.ElementNotFoundException;
import com.example.demo.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

	
	private ProductService service;

	public ProductController(ProductService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<RequestDto> save(@Valid @RequestBody RequestDto dto) throws Exception{
		
		return ResponseEntity.status(201).body(this.service.save(dto));
		
	}

	@GetMapping
	public ResponseEntity<List<RequestDto>> findAll(){
		
		return ResponseEntity.status(200).body(this.service.findAll());
	}
	

	@GetMapping(path = "/{id}")
	public ResponseEntity<RequestDto> findById(@PathVariable int id ) throws ElementNotFoundException{
		
		return ResponseEntity.ok(this.service.findById(id));
	}
	
	@GetMapping(path = "/srch/category/{category}")
	public ResponseEntity<List<ResponseDto>> findByCategory(@PathVariable String category ){
		
		return ResponseEntity.ok(this.service.findByCategory(category));
	}
	
	@GetMapping(path = "/srch/pricegt/{price}")
	public ResponseEntity<Collection<RequestDto>> findByPriceGrt(@PathVariable double price ){
		
		return ResponseEntity.ok(this.service.findPriceGrtThan(price));
	}
	
	@GetMapping(path = "/srch/pricelt/{price}")
	public ResponseEntity<Collection<RequestDto>> findByPriceLessthan(@PathVariable double price ){
		
		return ResponseEntity.ok(this.service.findPriceLessThan(price));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<RequestDto> update(@PathVariable int id, @Valid @RequestBody RequestDto dto) throws ElementNotFoundException {
	    return ResponseEntity.ok(this.service.update(id, dto));
	}

	
	@PatchMapping(path = "/update/price/{id}/{revised}")
	
	public ResponseEntity<RequestDto> updatePrice(@PathVariable int id , 
			           @PathVariable double revised){
		
		return ResponseEntity.ok(this.service.updateRatePerUnit(id,revised));
	}
	
@PatchMapping(path = "/update/category/{id}/{revised}")
	public ResponseEntity<RequestDto> updateCategory(@PathVariable int id , 
			           @PathVariable String revised){
		
		return ResponseEntity.ok(this.service.updateCategory(id,revised));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> DeleteById(@PathVariable int id ){
		
		this.service.deleteById(id);
		
		return ResponseEntity.noContent().build() ;  // return status code 204
	}
	
	
}
