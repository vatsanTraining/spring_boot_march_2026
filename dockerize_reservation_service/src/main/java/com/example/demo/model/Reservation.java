package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Objects;




public class Reservation {

	private Long id;
    private String passengerName;
    private LocalDateTime bookingDate;
    private Double totalAmount;
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
