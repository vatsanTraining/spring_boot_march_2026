package com.example.demo.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.demo.Product;
import com.example.demo.ifaces.ProductRepository;

@Repository  
//@Profile("dev")
@ConditionalOnProperty(havingValue = "list",name = "store.mode")
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
