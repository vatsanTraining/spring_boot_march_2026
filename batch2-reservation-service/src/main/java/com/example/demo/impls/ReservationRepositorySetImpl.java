package com.example.demo.impls;

import java.util.*;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.demo.ifaces.ReservationRepository;
import com.example.demo.model.Reservation;

//@Repository(value = "repo")
@Repository
@Profile("dev")
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
