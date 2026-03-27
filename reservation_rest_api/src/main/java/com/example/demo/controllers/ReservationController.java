package com.example.demo.controllers;

import java.util.Collection;
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

import com.example.demo.dto.RequestDto;
import com.example.demo.entity.Reservation;
import com.example.demo.services.ReservationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/reservations")
public class ReservationController {

	
	private ReservationService service;

	public ReservationController(ReservationService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	ResponseEntity<Collection<RequestDto>> findAll(){
		
		return ResponseEntity.ok(this.service.findAll());
		
	}
	
	@GetMapping(path = "/{id}")
	ResponseEntity<RequestDto> findById(@PathVariable Long id){
		
		return ResponseEntity.ok(this.service.findById(id));
		
	}
	
	@GetMapping(path = "/srch/name/{passName}")
	ResponseEntity<Collection<RequestDto>> findByPassengerName(@PathVariable String passName){
		
		return ResponseEntity.ok(this.service.findByPassengerName(passName));
		
	}

	@GetMapping(path = "/srch/amount/grt/{amount}")
	ResponseEntity<Collection<RequestDto>> amountGrtThan(@PathVariable double amount){
		
		return ResponseEntity.ok(this.service.amountGrtThan(amount));
		
	}
	@PostMapping
	ResponseEntity<RequestDto> save(@RequestBody RequestDto entity){
		
		System.out.println(entity);
		return ResponseEntity.status(201).body(this.service.save(entity));
	}
	
	

	
	@PatchMapping(path = "/{id}/{newStatus}")
	ResponseEntity<String> updateStatus(@PathVariable String newStatus,@PathVariable Long id){
		
		int rowsUpdated =this.service.updateStatus(newStatus,id);
		
		return ResponseEntity.ok("Rows Updated :=>"+rowsUpdated);
		
	}
	
	@DeleteMapping(path = "/{id}")
	ResponseEntity<Void> deleteById(@PathVariable Long id){
		
		this.service.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	


}
