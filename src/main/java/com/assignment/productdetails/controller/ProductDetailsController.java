package com.assignment.productdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.productdetails.exception.ResourceNotFoundException;
import com.assignment.productdetails.model.Product;
import com.assignment.productdetails.service.ProductDetailsService;

@RestController
@RequestMapping("/api/v1")
public class ProductDetailsController {

	@Autowired
	private ProductDetailsService service;
	
	
	/*
	 * this method returns product details for the id passed in the request
	 * @Param : id
	 * @Return: Product object for the id passed
	 */
	
	@GetMapping("/productdetails/{id}")
	public Product getProductDetailsById(@PathVariable String id) throws ResourceNotFoundException {
		return service.getProductDetailsById(id);
	}
}
