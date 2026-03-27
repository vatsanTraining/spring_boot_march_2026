package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

// one catalogue has many product

// make this entity
// create a repo
// create a service
// create a controller
// test with postman by adding a catalogue

@Entity
@Table(name = "catalogue_mar_26")
@AllArgsConstructor
@Data
public class Catalogue {


	@Id
	private Integer id;
	
	private String description;
	
	@OneToMany
	private List<Product> products;
	
	
}
