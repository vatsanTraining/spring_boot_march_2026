package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "catalogue_mar_26")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Catalogue {


	@Id
	private Integer id;
	
	private String description;
	
	@OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_catalogue_id", referencedColumnName = "id") 
	private List<Product> products;
	
	
	
	
}

