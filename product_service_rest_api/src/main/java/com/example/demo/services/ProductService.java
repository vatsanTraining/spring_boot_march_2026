package com.example.demo.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dtos.RequestDto;
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

	

	public RequestDto save(RequestDto obj) throws Exception {
		
		Product saved = this.repo.save(dtoToEntity(obj));
		
		return entityToDto(saved);
		
	}
	
	public Collection<Product> findAll(){
		
		return this.repo.findAll();
	}
	
public Collection<Product> findPriceGrtThan(double price){
		
		return this.repo.getPriceGrtThan(price);
		
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
	
	
	private RequestDto entityToDto(Product entity) {
		return new RequestDto(entity.getProductId(), entity.getProductName(),
				entity.getCategory(), entity.getRatePerUnit());
	}
	
	private Product dtoToEntity(RequestDto dto) throws Exception {
		return new Product(dto.productId(), dto.productName(), dto.category(), dto.ratePerUnit());
	}
	
	
}
