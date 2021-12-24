package com.assignment.productdetails.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assignment.productdetails.exception.ResourceNotFoundException;
import com.assignment.productdetails.model.Enrichment;
import com.assignment.productdetails.model.Images;
import com.assignment.productdetails.model.Item;
import com.assignment.productdetails.model.PrimaryBrand;
import com.assignment.productdetails.model.Product;
import com.assignment.productdetails.model.ProductClassification;
import com.assignment.productdetails.model.ProductDescription;
import com.assignment.productdetails.repository.ProductDetailsRepository;

@ExtendWith(MockitoExtension.class)
public class ProductDetailsServiceTest {

	@Mock
	private ProductDetailsRepository repository;
	
	@InjectMocks
	private ProductDetailsService service;
	
	@Test
	public void testGetProductDetailsById() throws ResourceNotFoundException { 
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
		
		Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.ofNullable(product));
		
		Product actualProduct = service.getProductDetailsById("1234765");
		
		Assertions.assertThat(product.getItem().getProductDescription().getTitle().equals(("BlueRay")));
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyString());
	}
}
