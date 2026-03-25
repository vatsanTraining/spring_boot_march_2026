package com.example.demo.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

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
}
