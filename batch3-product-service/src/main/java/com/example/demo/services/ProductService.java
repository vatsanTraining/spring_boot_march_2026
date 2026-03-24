package com.example.demo.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.Product;
import com.example.demo.ifaces.ProductRepository;

@Service
public class ProductService {

	
	
	private ProductRepository repo;

	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public boolean save(Product obj) {
		
		return this.repo.save(obj);
		
	}
	
	public Collection<Product> findAll(){
		
		return this.repo.findAll();
	}
}
