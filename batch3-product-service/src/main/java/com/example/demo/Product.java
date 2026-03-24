package com.example.demo;

import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Product {

	
	private int productId;
	private String productName;
	private String category;
	private double ratePerUnit;
	
	public Product() {
		super();
	}
	public Product(int productId, String productName, String category, double ratePerUnit) throws Exception {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		
		if(ratePerUnit<=0) {
			throw new Exception("Value should not be negative");
		}else {
			this.ratePerUnit = ratePerUnit;

		}
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(category, productId, productName, ratePerUnit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && productId == other.productId
				&& Objects.equals(productName, other.productName)
				&& Double.doubleToLongBits(ratePerUnit) == Double.doubleToLongBits(other.ratePerUnit);
	}
	@Override
	public String toString() {
		return this.productId +","+this.productName+","+this.category+","+this.ratePerUnit;
	}
		
}
