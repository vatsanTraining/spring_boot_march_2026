package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Catalogue;
import com.example.demo.services.CatalogueService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = "/api/v1/catalogues")
@AllArgsConstructor
public class CatalogueController {

	
	
	private CatalogueService service;
	
	
	@GetMapping
	ResponseEntity<List<Catalogue>> findAll(){
		
		return ResponseEntity.ok(this.service.findAll());
	}
	
	@PostMapping
	ResponseEntity<Catalogue> save(@RequestBody Catalogue entity ){
		
		return ResponseEntity.status(201).body(this.service.save(entity));
	}
	
}
