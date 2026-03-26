package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "reservation_mar_26")
public class Reservation {

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "passenger_name")
    private String passengerName;
	
	@Column(name = "booking_date")
	private LocalDateTime bookingDate;
    
	@Column(name = "total_amount")
	private Double totalAmount;
    
	@Column(name = "status")
	private String status;
    
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation(Long id, String passengerName, LocalDateTime bookingDate, Double totalAmount, String status) {
		super();
		this.id = id;
		this.passengerName = passengerName;
		this.bookingDate = bookingDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, id, passengerName, status, totalAmount);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(bookingDate, other.bookingDate) && Objects.equals(id, other.id)
				&& Objects.equals(passengerName, other.passengerName) && Objects.equals(status, other.status)
				&& Objects.equals(totalAmount, other.totalAmount);
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", passengerName=" + passengerName + ", bookingDate=" + bookingDate
				+ ", totalAmount=" + totalAmount + ", status=" + status + "]";
	} 
 
    
    
}
