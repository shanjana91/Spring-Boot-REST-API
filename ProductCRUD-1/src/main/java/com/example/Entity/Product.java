package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//MODEL CLASS

@Data
@Entity
public class Product {
	@Id
	@GeneratedValue
	@ApiModelProperty(notes = "Product ID", name = "id", required = true)
	private int id;

	@ApiModelProperty(notes = "Product Name", name = "name", required = true)
	private String name;

	@ApiModelProperty(notes = "Product quantity in stock", name = "quantity", required = true)
	private int quantity;

	@ApiModelProperty(notes = "Product price", name = "price", required = true)
	private int price;
}
