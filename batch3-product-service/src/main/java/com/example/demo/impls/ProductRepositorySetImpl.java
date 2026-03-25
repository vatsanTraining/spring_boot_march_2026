package com.example.demo.impls;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.demo.Product;
import com.example.demo.ifaces.ProductRepository;

@Repository
//@Primary
//@Profile("prod")
@ConditionalOnProperty(havingValue = "set",name = "store.mode")
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
