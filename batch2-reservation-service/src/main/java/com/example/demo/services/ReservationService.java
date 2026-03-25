package com.example.demo.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.ifaces.ReservationRepository;
import com.example.demo.model.Reservation;

@Service
public class ReservationService {

	
	private ReservationRepository repo;

	public ReservationService(ReservationRepository repo) {
		super();
		this.repo = repo;
		
		System.out.println(this.repo.getClass().getName());
	}
	
	
	public boolean save(Reservation obj) {
		
		return this.repo.save(obj);
	}
	
	public Collection<Reservation> findAll(){
		
		return this.repo.findAll();
	}
}
