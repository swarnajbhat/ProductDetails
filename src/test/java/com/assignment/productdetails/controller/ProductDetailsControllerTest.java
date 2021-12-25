package com.assignment.productdetails.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment.productdetails.model.Enrichment;
import com.assignment.productdetails.model.Images;
import com.assignment.productdetails.model.Item;
import com.assignment.productdetails.model.PrimaryBrand;
import com.assignment.productdetails.model.Product;
import com.assignment.productdetails.model.ProductClassification;
import com.assignment.productdetails.model.ProductDescription;
import com.assignment.productdetails.service.ProductDetailsService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProductDetailsController.class)
public class ProductDetailsControllerTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private ProductDetailsService service;
	
	@Test
	public void testGetProductDetailsById() throws Exception {
		Product product = new Product();
		
		ProductDescription description = new ProductDescription();
		description.setDownstreamDescription("description");
		description.setTitle("BlueRay");
		
		Images images = new Images();
		images.setPrimaryImageUrl("image url");
		Enrichment enrichment = new Enrichment();
		enrichment.setImages(images);
		
		ProductClassification classification = new ProductClassification();
		classification.setMerchandiseTypeName("Movies");
		classification.setProductTypeName("ELECTRONICS");
		
		PrimaryBrand brand = new PrimaryBrand();
		brand.setName("Universal Home Video");
		
		Item item = new Item();
		item.setEnrichment(enrichment);
		item.setPrimaryBrand(brand);
		item.setProductClassification(classification);
		item.setProductDescription(description);
		
		product.setId("1234654");
		product.setItem(item);
		
		Mockito.when(service.getProductDetailsById(Mockito.anyString())).thenReturn((product));
		
		mockmvc.perform(get("/api/v1/productdetails/{id}",1234654))
		.andExpectAll(jsonPath("$.item.productDescription.title").value("BlueRay"));
	}
}
