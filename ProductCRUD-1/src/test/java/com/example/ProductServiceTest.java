package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Entity.Product;
import com.example.Repository.ProductRepo;
import com.example.Service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {
	@Autowired
	private ProductService service;
	
	@MockBean
	private ProductRepo repo;
	
	@Test
	public void getAllProductsTest() {
		Product p1=new Product(1, "Mobile", 23, 15000);
		Product p2=new Product(2,"Monitor",34,18000);
		List<Product> products=new ArrayList<>();
		products.add(p1);
		products.add(p2);
		
		when(repo.findAll()).thenReturn(products);
		assertEquals(2, service.getProducts().size());
	}
	
	@Test
	public void getProductByIdTest() {
		int id=1;
		Product p=new Product(1, "MOBILE", 3, 15000);
		Optional<Product> prodOptional=Optional.of(p);
		when(repo.findById(id)).thenReturn(prodOptional);
		assertEquals(1, service.getProductByid(id).getId());
		assertEquals("MOBILE", service.getProductByid(id).getName());
		assertEquals(null,service.getProductByid(3));
	}
	
	@Test
	public void getProductByNameTest() {
		String name="Mobile";
		when(repo.findByName(name)).thenReturn(new Product(1, "MOBILE", 3, 15000));
		assertEquals(1, service.getProductByName(name).getId());
		assertEquals("MOBILE", service.getProductByName(name).getName());
	}
	
	@Test
	public void createProductTest() {
		Product p=new Product(23, "Microphone", 25, 1500);
		when(repo.save(p)).thenReturn(p);
		assertEquals(p, service.create(p));
		assertEquals("Microphone", service.create(p).getName());
	}
	
	@Test
	public void deleteProductsTest() {
		int id=1;
		service.deleteProduct(id);
		verify(repo,times(1)).deleteById(id); //since deletebyid returns void , you could oly verify if this method is called
	}
	
	@Test
	public void updateProductsTest() {
		int id=1;
		Product p=new Product(1, "MOBILE", 3, 15000);
		Optional<Product> prodOptional=Optional.of(p);
		when(repo.findById(id)).thenReturn(prodOptional);
		assertEquals(15000, service.getProductByid(id).getPrice());
		
		p.setPrice(18000);
		when(repo.save(p)).thenReturn(p);
		assertEquals(18000, service.updateProduct(p).getPrice());
	}
}
