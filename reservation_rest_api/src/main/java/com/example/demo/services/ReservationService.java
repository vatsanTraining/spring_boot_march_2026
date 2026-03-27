package com.example.demo.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.RequestDto;
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

	public RequestDto save(RequestDto obj) {
		
		Reservation saved= this.repo.save(dtoToEntity(obj));
		
		return entityToDto(saved);
	}
	
	public Collection<Reservation> findAll(){
		
		return this.repo.findAll();
	}
	
	public Reservation findById(Long id) {
		
		return this.repo.findById(id)
				.orElseThrow(()-> new RuntimeException("Element with Id "+ id + " Not Found"));
	}
	
	public void deleteById(Long id) {
		

		
		if(!this.repo.existsById(id)) {
			
			throw new RuntimeException("Element with Id "+ id + "Not Found");
		}
		this.repo.deleteById(id);
	}
	
	public int updateStatus(String newStatus, Long id) {
		
		return this.repo.updateStatus(newStatus, id);
		
	}
	
	public List<Reservation> findByPassengerName(String passName){
		
		return this.repo.findByPassengerName(passName);
	}
	
public List<ResponseDto> findByStatus(String status){
		
		return this.repo.findByStatus(status);
	}


public List<Reservation> amountGrtThan(double amt){
	
	return this.repo.amountLessThan(amt);
}

public List<Reservation> amountLessThan(double amt){
	
	return this.repo.amountGrtThan(amt);
}


	private RequestDto entityToDto(Reservation obj) {
		
		RequestDto dto = new RequestDto(obj.getId(), obj.getPassengerName(), 
				 obj.getBookingDate(), obj.getTotalAmount(), obj.getStatus());
		
		return dto;
	}
	
	private Reservation dtoToEntity(RequestDto dto) {
		
		Reservation obj =
				new Reservation(dto.id(), dto.passengerName(), dto.bookingDate(), 
						               dto.totalAmount(),dto.status());
		
		return obj;
	
	}
}
