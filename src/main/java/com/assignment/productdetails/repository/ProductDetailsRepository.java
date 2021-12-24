package com.assignment.productdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.productdetails.model.Product;
import com.assignment.productdetails.model.ProductDetails;

@Repository
public interface ProductDetailsRepository extends MongoRepository<Product,String> {

}
