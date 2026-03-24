package com.example.demo.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Product;
import com.example.demo.ifaces.ProductRepository;

@Repository
public class ProductRepositoryListImpl implements ProductRepository {

	private List<Product> productList;

	

	
	public ProductRepositoryListImpl() {
		super();
		
		this.productList = new ArrayList<>();
	}

	@Override
	public boolean save(Product obj) {
		return this.productList.add(obj);
	}

	@Override
	public List<Product> findAll() {
		return this.productList;
	}

}
