package com.assignment.productdetails.model;

import org.springframework.stereotype.Component;

@Component
public class ProductDetails {

	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
