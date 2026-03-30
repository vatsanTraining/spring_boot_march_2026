package com.example.demo.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Reservation;
import com.example.demo.ifaces.ReservationRepository;
import com.example.demo.utils.ElementNotFoundException;


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

	public Collection<RequestDto> findAll(){
		
		
		return mapper(this.repo.findAll());
		
	}

	
	
	public RequestDto findById(Long id) throws ElementNotFoundException {
		
		
		return this.repo.findById(id).map(this::entityToDto)
		   .orElseThrow(() -> new ElementNotFoundException("Element with Id "+ id + " Not Found"));
		
			}
	
	public void deleteById(Long id) throws ElementNotFoundException {
		

		
		if(!this.repo.existsById(id)) {
			
			throw new ElementNotFoundException("Element with Id "+ id + "Not Found");
		}
		this.repo.deleteById(id);
	}
	
	
	public Collection<RequestDto> findByPassengerName(String passName){
		
		
		return mapper(this.repo.findByPassengerName(passName));
	}
	
public List<ResponseDto> findByStatus(String status){
		
		return this.repo.findByStatus(status);
		
	}


public int updateStatus(String newStatus, Long id) {
	
	return this.repo.updateStatus(newStatus, id);
	
}

public RequestDto update(Long id,  RequestDto dto) throws ElementNotFoundException {
	
	Reservation existing = this.repo.findById(id)
	        .orElseThrow(() -> new ElementNotFoundException("Reservation not found with id: " + id));

	    existing.setPassengerName(dto.passengerName());
	    existing.setBookingDate(dto.bookingDate());
	    existing.setTotalAmount(dto.totalAmount());
	    existing.setStatus(dto.status());

	    Reservation saved = this.repo.save(existing);
	
	    return entityToDto(saved);

}
public Collection<RequestDto> amountGrtThan(double amt){
	
	
	 return mapper(this.repo.amountGrtThan(amt));
}

public Collection<RequestDto> amountLessThan(double amt){
	
	return  mapper(this.repo.amountLessThan(amt));
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
	private Collection<RequestDto> mapper(List<Reservation> list) {
		return list.stream().map(this::entityToDto).toList();
	}

	
	
}
