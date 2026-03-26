package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Reservation;
import com.example.demo.services.ReservationService;

@SpringBootApplication
public class Batch2DataJpaReservationServiceApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx= SpringApplication.run(Batch2DataJpaReservationServiceApplication.class, args);
		
		
		  Reservation tom = ctx.getBean("tom",Reservation.class);
		   
		   Reservation dick = ctx.getBean("dick",Reservation.class);

		   Reservation harry = ctx.getBean("harry",Reservation.class);
		   
		   Reservation amar = ctx.getBean("amar",Reservation.class);
		   
		   ReservationService service = ctx.getBean(ReservationService.class);
		   
		   
		   service.save(harry);
		   service.save(dick);
		   service.save(tom);
		   service.save(amar);
	
		   
		   service.findAll().forEach(System.out::println);
		   
		   
		   System.out.println("List By Passenger Name");

		    service.findByPassengerName("Tommy").forEach(System.out::println);
		   
		   
		   System.out.println("Using Projection");
		   
		   service.findByStatus("CNF").forEach(System.out::println);
		   
		   
		   service.deleteById(1004L);
		   
		   System.out.println("List AFter Deleting Amar");
		   
		   service.findAll().forEach(System.out::println);
		   
	}

	@Bean
	Reservation tom() {
		
		return new Reservation(1001L, 
				"Tommy",LocalDateTime.of(
						LocalDate.of(2025,Month.FEBRUARY,14),LocalTime.now()) 
				,5300.00D, "CNF");
	}
	
	@Bean
	Reservation dick() {
		
		return new Reservation(1002L, 
				"Dick",LocalDateTime.of(
						LocalDate.of(2026,Month.JANUARY,26),LocalTime.of(10,30)) 
				,6300.00D, "CNF");
	}
	
	@Bean
	Reservation harry() {
		
		return new Reservation(1003L, 
				"Harry",LocalDateTime.of(
						LocalDate.of(2026,Month.JUNE,16),LocalTime.of(14,30)) 
				,7300.00D, "PEN");
	}
	
	@Bean
	Reservation amar() {
		
		return new Reservation(1004L, 
				"Amar",LocalDateTime.of(
						LocalDate.of(2026,Month.JUNE,16),LocalTime.of(14,30)) 
				,7300.00D, "PEN");
	}
}
