package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Catalogue;
import com.example.demo.ifaces.CatalogueRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CatalogueService {

	
	private CatalogueRepository repo;
	
	
	public Catalogue save(Catalogue entity) {
		
		return this.repo.save(entity);
	}
	
public List<Catalogue> findAll() {
		
		return this.repo.findAll();
	}
	
}
