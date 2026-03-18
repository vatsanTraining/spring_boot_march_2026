package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Customer;
import com.example.demo.ifaces.CustomerRepository;

@Service
public class CustomerService {

	
	private CustomerRepository repo;

	public CustomerService(CustomerRepository repo) {
		super();
		
		this.repo = repo;
		
		System.out.println(repo.getClass().getName());
	}
	
	
	public Customer save(CustomerDto dto) {
		
		
		return this.repo.save(mapToEntity(dto));
	}


	
	public List<Customer> findAll(){
		
		return this.repo.findAll();
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
