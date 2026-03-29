package com.example.demo.services;

import java.util.Collection;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dtos.RequestDto;
import com.example.demo.dtos.ResponseDto;
import com.example.demo.entity.Product;
import com.example.demo.exceptions.ElementNotFoundException;
import com.example.demo.ifaces.ProductRepository;

import java.util.Optional;
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
	
	public List<RequestDto> findAll(){
		
		
		return this.repo.findAll().stream().map(this::entityToDto).toList();
		
	}
	
public List<ResponseDto> findByCategory(String srch){
		
		
		return this.repo.findByCategory(srch);
		
	}
	
public Collection<RequestDto> findPriceGrtThan(double price){
		
		return this.repo.getPriceGrtThan(price).stream().map(this::entityToDto).toList();
		
	}

public Collection<RequestDto> findPriceLessThan(double price){
	
	return this.repo.getPriceLessThan(price).stream().map(this::entityToDto).toList();
	
}


	@Transactional
	public RequestDto updateRatePerUnit(int id,double revised) {
		
		
		Product found =repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Element With "+id +"Not found"));

		   found.setRatePerUnit(revised);
		   
		   
               return entityToDto(found);
	}
	

	@Transactional
	public RequestDto updateCategory(int id,String revised) {
		
		
		Product found =repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Element With "+id +"Not found"));

		   found.setCategory(revised);
		   
		   
               return entityToDto(found);
	}

	
	
	
	
	public RequestDto findById(int id)  throws ElementNotFoundException {
		
		    return repo.findById(id)
		               .map(this::entityToDto)
		               .orElseThrow(() -> new ElementNotFoundException("Product not found with id: " + id));
		

		
	}
	
public RequestDto update(int id,  RequestDto dto) throws ElementNotFoundException {
		
		Product existing = this.repo.findById(id)
		        .orElseThrow(() -> new ElementNotFoundException("Reservation not found with id: " + id));

		    existing.setProductName(dto.productName());
		    existing.setCategory(dto.category());
		    existing.setRatePerUnit(dto.ratePerUnit());

		    Product saved = this.repo.save(existing);
		
		    return entityToDto(saved);

	}

	
	public void deleteById(int id) {
	    
	 if(!this.repo.existsById(id)) {
		 
		 throw new RuntimeException("Element With "+id +"Not found");
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
