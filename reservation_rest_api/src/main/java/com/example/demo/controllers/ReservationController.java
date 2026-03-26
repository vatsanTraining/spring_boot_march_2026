package com.example.demo.controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Reservation;
import com.example.demo.services.ReservationService;

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
	
}
