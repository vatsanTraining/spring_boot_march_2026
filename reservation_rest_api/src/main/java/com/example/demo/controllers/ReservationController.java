package com.example.demo.controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Reservation;
import com.example.demo.services.ReservationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/reservations")
public class ReservationController {

	
	private ReservationService service;

	public ReservationController(ReservationService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	ResponseEntity<Collection<Reservation>> findAll(){
		
		return ResponseEntity.ok(this.service.findAll());
		
	}
	
	@GetMapping(path = "/{id}")
	ResponseEntity<Reservation> findById(@PathVariable Long id){
		
		return ResponseEntity.ok(this.service.findById(id));
		
	}
	
	@PostMapping
	ResponseEntity<Reservation> save(@RequestBody Reservation entity){
		
		return ResponseEntity.status(201).body(this.service.save(entity));
	}
	

}
