package com.example.demo.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Reservation;
import com.example.demo.ifaces.ReservationRepository;

@Service
public class ReservationService {

	
	private ReservationRepository repo;
	
	

	public ReservationService(ReservationRepository repo) {
		super();
		this.repo = repo;
		
		System.out.println(this.repo.getClass().getName());
	}

	public Reservation save(Reservation obj) {
		
		return this.repo.save(obj);
	}
	
	public Collection<Reservation> findAll(){
		
		return this.repo.findAll();
	}
	
	public Reservation findById(Long id) {
		
		return null;
	}
	
	public void deleteById(Long id) {
		
	}
	
	public Reservation updateStatus(Long id,String status) {
		
		return null;
	}
	
	
	public List<Reservation> findByPassengerName(String passName){
		
		return null;
	}
	
public List<ResponseDto> findByStatus(String status){
		
		return null;
	}


public List<Reservation> amountGrtThan(double amt){
	
	return null;
}

public List<Reservation> amountLessThan(double amt){
	
	return null;
}




	
	
}
