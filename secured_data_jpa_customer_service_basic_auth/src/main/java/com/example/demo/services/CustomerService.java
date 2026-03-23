package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Customer;
import com.example.demo.exceptions.ElementNotFoundException;
import com.example.demo.ifaces.CustomerRepository;


@Service
public class CustomerService {

	
	private CustomerRepository repo;

	public CustomerService(CustomerRepository repo) {
		super();
		
		this.repo = repo;
		
		System.out.println(repo.getClass().getName());
	}
	
	
	public CustomerDto save(CustomerDto dto) {
		
		
		Customer added = this.repo.save(mapToEntity(dto));
		
		return mapToDto(added);
	}


	
	public List<Customer> findAll(){
		
		return this.repo.findAll();
	}
	
	public CustomerDto findById(Long id) throws ElementNotFoundException {
		
		Customer found= this.repo.findById(id).orElseThrow(()->new ElementNotFoundException(id));
	
		 return mapToDto(found);
	}
	
public void removeById(Long id) throws ElementNotFoundException {

	  if(!this.repo.existsById(id)) {
		  throw new ElementNotFoundException(id);
	  }
	  
	   this.repo.deleteById(id);
	  
	}
	
@Transactional 
public CustomerDto updatePhoneNumber(Long id, long numberToUpdate) throws ElementNotFoundException {
	
Customer found =repo.findById(id)
            .orElseThrow(() -> new ElementNotFoundException(id));

      found.setPhoneNumber(numberToUpdate);

      return mapToDto(found); 
    
}


@Transactional
public CustomerDto updateCustomer(CustomerDto dto) throws ElementNotFoundException {
	
	if (!repo.existsById(dto.customerId())) {
        throw new ElementNotFoundException(dto.customerId());
    }
     Customer updated= repo.save(mapToEntity(dto));
     
     return mapToDto(updated);
    
}
	
	public ResponseDto findByCustomerName(String custName) {
		
		return this.repo.findByCustomerName(custName);
	}
	
	public CustomerDto findByPhone(long phone) {
		
		Customer cust =this.repo.fetchByPhone(phone);
		
		return mapToDto(cust);
	}
	
	


	private CustomerDto mapToDto(Customer cust) {
		return new CustomerDto(cust.getCustomerId(), cust.getCustomerName(), cust.getEmail(), cust.getPhoneNumber());
	}
	
	private Customer mapToEntity(CustomerDto dto) {
		return  new Customer(dto.customerId(),dto.customerName(),dto.phoneNumber(),dto.email());
	}
	
}
