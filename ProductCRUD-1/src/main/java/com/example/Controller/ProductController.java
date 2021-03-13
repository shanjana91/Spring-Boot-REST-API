package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Product;
import com.example.Service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service; //controller --> service
	
	@PostMapping("/create")
	public Product addProduct(@RequestBody Product product) {
		return service.create(product);
	}
	
	@PostMapping("/createProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.createproducts(products);
	}
	
	@GetMapping("/getById/{id}")
	public Product getProductById(@PathVariable int id){
		return service.getProductByid(id);
	}
	
	@GetMapping("/get/{name}")
	public Product getProductByName(@PathVariable String name){
		return service.getProductByName(name);
	}
	
	@GetMapping("/getproducts")
	public List<Product> getProducts(){
		return service.getProducts();
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	@PutMapping("/update/{id}")
	public Product update(@RequestBody Product product) {
		return service.updateProduct(product);
	}
}
