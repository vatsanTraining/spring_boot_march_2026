package com.example.demo.ifaces;

import java.util.Collection;
import java.util.List;

import com.example.demo.model.Reservation;

public interface ReservationRepository {

	boolean save(Reservation obj);
	Collection<Reservation> findAll();
	
}
