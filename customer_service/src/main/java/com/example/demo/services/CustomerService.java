package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
	
	public Customer save(Customer entity) {
		
		return this.repo.save(entity);
	}
	
	public List<Customer> findAll(){
		
		return this.repo.findAll();
	}
}
