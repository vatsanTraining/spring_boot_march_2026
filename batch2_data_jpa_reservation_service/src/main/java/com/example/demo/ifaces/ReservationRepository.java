package com.example.demo.ifaces;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long>{


	//DSL Query
	List<Reservation> findByPassengerName(String srch);
	
	// DSL query with projection
	List<ResponseDto> findByStatus(String srch);
	
	//Using Custom Query with Native Query
	
	@Query(value = "select * from reservation_mar_26 where total_amount>:srch",nativeQuery = true)
	List<Reservation> amountGrtThan(@Param("srch") double amount);
	
	//Using Custom Query with JPQL

	@Query(value = "from Reservation where totalAmount<:srch",nativeQuery = false)
	List<Reservation> amountLessThan(@Param("srch") double amount);
	
	
	@Query(value = "Update Reservation set status =:newStatus where id=:id",nativeQuery = false)
	@Modifying
	@Transactional
	int updateStatus(@Param("newStatus") String newStatus , @Param("id") Long id);
	
	
}
