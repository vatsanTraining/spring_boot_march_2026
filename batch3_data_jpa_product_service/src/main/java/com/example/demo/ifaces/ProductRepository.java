package com.example.demo.ifaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	  @Query(value = "select * from product_mar_26 where rate_per_unit>:val ",nativeQuery = true)
	  List<Product> getPriceGrtThan(@Param("val") double srch);
}
