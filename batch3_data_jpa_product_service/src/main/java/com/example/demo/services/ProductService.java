package com.example.demo.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public Product updateRatePerUnit(int id,double revised) {
		
		
		Product found =repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Element With "+id +"Not found"));

		   found.setRatePerUnit(revised);
		   
               return found;
	}
	
	public Product findById(int id) {
		
		return this.repo.findById(id).orElseThrow(()-> new RuntimeException("Element With given Id Not found"));
	}
	
	public void deleteById(int id) {
	    
	 if(!this.repo.existsById(id)) {
		 
		 throw new RuntimeException("Element with given id not found");
	 } else {
	       this.repo.deleteById(id);
	 }
	}
}
