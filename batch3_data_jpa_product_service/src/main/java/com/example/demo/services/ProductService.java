package com.example.demo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.ifaces.ProductRepository;

@Service
public class ProductService {

	
	
	private ProductRepository repo;
	
	
//	//Constructor Injection
//	public ProductService(@Qualifier("productRepositorySetImpl") ProductRepository repo) {
//		super();
//		this.repo = repo;
//		System.out.println(repo.getClass().getName());
//	}
//	

	//Constructor Injection
	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
		System.out.println(repo.getClass().getName());
	}

	

	public Product save(Product obj) {
		
		return this.repo.save(obj);
		
	}
	
	public Collection<Product> findAll(){
		
		return this.repo.findAll();
	}
}
