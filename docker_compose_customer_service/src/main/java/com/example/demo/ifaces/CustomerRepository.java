package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
	ResponseDto findByCustomerName(String custName);
	
	// Select * from customer_mar_26 where phoneNumber=?
	// using className and attribute since its a native query
	
	@Query(value = "from Customer where phoneNumber=:srch",nativeQuery = false)
	Customer fetchByPhone(@Param("srch") long phoneNumber);
	
	
	
}
