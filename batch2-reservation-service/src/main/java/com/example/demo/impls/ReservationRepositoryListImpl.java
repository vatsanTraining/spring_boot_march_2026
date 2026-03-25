package com.example.demo.impls;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.ifaces.ReservationRepository;
import com.example.demo.model.Reservation;

public class ReservationRepositoryListImpl implements ReservationRepository {

	private List<Reservation> list;
	
	
	public ReservationRepositoryListImpl() {
		super();
		this.list = new ArrayList<>();
	}

	@Override
	public boolean save(Reservation obj) {
		return this.list.add(obj);
	}

	@Override
	public List<Reservation> findAll() {
		return this.list;
	}

}
