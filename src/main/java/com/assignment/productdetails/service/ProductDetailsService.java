package com.assignment.productdetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.productdetails.exception.ResourceNotFoundException;
import com.assignment.productdetails.model.Product;
import com.assignment.productdetails.repository.ProductDetailsRepository;

@Service
public class ProductDetailsService {

	@Autowired
	private ProductDetailsRepository repository;
	
	public Product getProductDetailsById(String id) throws ResourceNotFoundException {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Resource not found"));
	}
}
