package com.example.demo.impls;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.demo.Product;
import com.example.demo.ifaces.ProductRepository;

@Repository
public class ProductRepositorySetImpl implements ProductRepository {

	private Set<Product> productList;

	
	public ProductRepositorySetImpl() {
		super();
		
		this.productList = new HashSet<>();
	}

	@Override
	public boolean save(Product obj) {
		return this.productList.add(obj);
	}

	@Override
	public Set<Product> findAll() {
		return this.productList;
	}

}
