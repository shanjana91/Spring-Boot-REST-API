package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class ProductCrud1Application extends SpringBootServletInitializer {

	//JAR
	public static void main(String[] args) {
		SpringApplication.run(ProductCrud1Application.class, args);
	}
	
	//WAR
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(ProductCrud1Application.class);
	    }

}
