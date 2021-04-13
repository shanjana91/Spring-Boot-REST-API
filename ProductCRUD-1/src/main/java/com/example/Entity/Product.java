package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

//MODEL CLASS

@Entity
public class Product {
	@Id
	@GeneratedValue
	@ApiModelProperty(notes = "Product ID" ,name = "id",required=true)
	private int id;
	@ApiModelProperty(notes = "Product Name" ,name = "name",required = true)
	private String name;
	@ApiModelProperty(notes = "Product quantity in stock" ,name = "quantity",required = true)
	private int quantity;
	@ApiModelProperty(notes = "Product price" ,name = "price",required = true)
	private int price;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Product(int id, String name, int quantity, int price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
