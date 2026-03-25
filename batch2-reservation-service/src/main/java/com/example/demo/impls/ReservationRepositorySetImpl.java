package com.example.demo.impls;

import java.util.*;

import com.example.demo.ifaces.ReservationRepository;
import com.example.demo.model.Reservation;

public class ReservationRepositorySetImpl implements ReservationRepository {

	
	private Set<Reservation> set;
	
	
	public ReservationRepositorySetImpl() {
		super();
		
		this.set = new HashSet<>();
	}

	@Override
	public boolean save(Reservation obj) {
		return this.set.add(obj);
	}

	@Override
	public Set<Reservation> findAll() {
		return this.set;
	}

}
