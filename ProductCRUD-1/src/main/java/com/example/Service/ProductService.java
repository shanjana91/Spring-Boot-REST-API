package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Product;
import com.example.Repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo repo; //service--> repository
	
	//PUT
	public Product create(Product product) {
		Product p=repo.save(product); //default method of JPA to make the data persist in the DB
		return p;
	}
	
	
	public List<Product> createproducts(List<Product> products) {
		List<Product> p=repo.saveAll(products); 
		return p;
		
	}
	
	//GET
	public List<Product> getProducts(){
		List<Product> p=repo.findAll();
		return p;
	}
	
	public Product getProductByid(int id){
		Product p=repo.findById(id).orElse(null); //return id , if id not found then return null
		return p;
	}
	
	public Product getProductByName(String name){
		Product p=repo.findByName(name); //customized method in JPA (declared in the interface)
		return p;
	}
	
	//DELETE
	public String deleteProduct(int id) {
		repo.deleteById(id);
		return "Product removed : "+id;
	}
	
	//UPDATE
	public Product updateProduct(Product product) {
		Product existing=repo.findById(product.getId()).orElse(null);
		existing.setName(product.getName());
		existing.setPrice(product.getPrice());
		existing.setQuantity(product.getQuantity());
		Product p=repo.save(existing);
		return p;
		
	}
	
}
