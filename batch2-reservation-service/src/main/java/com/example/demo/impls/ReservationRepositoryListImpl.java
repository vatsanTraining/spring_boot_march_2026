package com.example.demo.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.demo.ifaces.ReservationRepository;
import com.example.demo.model.Reservation;

@Repository
//@Primary
@Profile("prod")
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
