package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Customer;
import com.example.demo.exceptions.ElementNotFoundEception;
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
	
	public Customer findById(Long id) throws ElementNotFoundEception {
		
		return this.repo.findById(id).orElseThrow(()->new ElementNotFoundEception(id));
	}
	
public void removeById(Long id) throws ElementNotFoundEception {

	  if(!this.repo.existsById(id)) {
		  throw new ElementNotFoundEception(id);
	  }
	  
	   this.repo.deleteById(id);
	  
	}
	
@Transactional 
public Customer updatePhoneNumber(Long id, long numberToUpdate) throws ElementNotFoundEception {
	
Customer found =repo.findById(id)
            .orElseThrow(() -> new ElementNotFoundEception(id));

      found.setPhoneNumber(numberToUpdate);

      return found; 
    
}


@Transactional
public Customer updateCustomer(Customer cust) throws ElementNotFoundEception {
	
	if (!repo.existsById(cust.getCustomerId())) {
        throw new ElementNotFoundEception(cust.getCustomerId());
    }
     return repo.save(cust);
    
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
