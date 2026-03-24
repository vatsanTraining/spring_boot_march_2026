package com.example.demo.ifaces;

import java.util.List;

import com.example.demo.Product;

public interface ProductRepository {

	boolean save(Product obj);
	List<Product> findAll();
}
