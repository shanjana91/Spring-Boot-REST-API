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

import io.swagger.annotations.ApiOperation;

@RestController
public class ProductController {

	@Autowired
	private ProductService service; // controller --> service

	@ApiOperation(value = "Insert Product Records", response = Product.class)
	@PostMapping("/create")
	public Product addProduct(@RequestBody Product product) {
		return service.create(product);
	}

	@ApiOperation(value = "Insert more than one Product Records", response = Product.class)
	@PostMapping("/createProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.createproducts(products);
	}

	@ApiOperation(value = "Retrieve Product Records by ID", response = Product.class)
	@GetMapping("/getById/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProductByid(id);
	}

	@ApiOperation(value = "Retrieve Product Record By name", response = Product.class)
	@GetMapping("/get/{name}")
	public Product getProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}

	@ApiOperation(value = "Retrieve all Product Records", response = Product.class)
	@GetMapping("/getproducts")
	public List<Product> getProducts() {
		return service.getProducts();
	}

	@ApiOperation(value = "Delete a Product Record", response = Product.class)
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

	@ApiOperation(value = "Update a Product Record", response = Product.class)
	@PutMapping("/update/{id}")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
}
