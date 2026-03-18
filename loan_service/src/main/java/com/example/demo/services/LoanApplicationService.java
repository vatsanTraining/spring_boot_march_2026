package com.example.demo.services;
import com.example.demo.model.*;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.repos.LoanApplicationRepository;

@Service
public class LoanApplicationService {

	
	
	 private LoanApplicationRepository repo;

	 
	public LoanApplicationService(LoanApplicationRepository repo) {
		super();
		this.repo = repo;
		
		System.out.println(this.repo.getClass().getName());
	}
	 
	 
	 
	public List<LoanApplication> findAll(){
		
		return this.repo.findAll();
	}
	
   public LoanApplication findById(int id){
		
		return this.repo.findById(id)
				  .orElseThrow(() -> 
				    new RuntimeException("Element with Id "+id+" Not Available"));
	}
	
	public boolean save(LoanApplication entity) {
		return this.repo.save(entity);
	}
	
	public List<LoanApplication> findByName(String qryString){
		
		return this.repo.findByApplicantName(qryString);
	}
	

}
