package com.example.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

	Product findByName(String name);
													//name of model class and data type of Pkey
}
