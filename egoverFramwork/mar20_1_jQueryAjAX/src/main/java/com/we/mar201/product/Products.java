package com.we.mar201.product;

import java.util.List;

public class Products {
	private List<Product> product;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(List<Product> product) {
		super();
		this.product = product;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
}
