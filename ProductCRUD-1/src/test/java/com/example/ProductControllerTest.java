package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.Controller.ProductController;
import com.example.Entity.Product;
import com.example.Service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ProductController.class) //to test MVC applications
class ProductControllerTest {

	@Autowired
	private MockMvc mockmvc; //to enable server side testing capability
	
	@MockBean
	private ProductService service;
	
	Product p=new Product(1,"Television",14,23000);
	
	@Test
	public void getProductsTest() throws Exception {
		List<Product> p_list=new ArrayList<>();
		p_list.add(p);
		when(service.getProducts()).thenReturn(p_list);
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/getproducts").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcresult=mockmvc.perform(requestBuilder).andReturn();
		int status=mvcresult.getResponse().getStatus();
		
		String expected="[{\"id\":1,\"name\":\"Television\",\"quantity\":14,\"price\":23000}]";
		assertEquals(expected, mvcresult.getResponse().getContentAsString());
		verify(service,times(1)).getProducts();
		assertEquals(200, status);
	}
	
	@Test
	public void getProductByIdTest() throws Exception {
		int id=1;
		when(service.getProductByid(id)).thenReturn(p);
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/getById/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockmvc.perform(requestBuilder).andReturn();
		int status=result.getResponse().getStatus();
		
		String expected="{\"id\":1,\"name\":\"Television\",\"quantity\":14,\"price\":23000}";
		assertEquals(expected, result.getResponse().getContentAsString());
		verify(service,times(1)).getProductByid(id);
		assertEquals(200, status);
	
	}
	
	@Test
	public void getProductByNameTest() throws Exception {
		String name="Television";
		when(service.getProductByName(name)).thenReturn(p);
		
		RequestBuilder requestbuilder=MockMvcRequestBuilders.get("/get/Television").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockmvc.perform(requestbuilder).andReturn();
		int status=result.getResponse().getStatus();
		
		String expected="{\"id\":1,\"name\":\"Television\",\"quantity\":14,\"price\":23000}";
		assertEquals(expected, result.getResponse().getContentAsString());
		verify(service,times(1)).getProductByName(name);
		assertEquals(200, status);
		
	}
	
	@Test
	public void deleteProductTest() throws Exception {
		int id=1;
		when(service.deleteProduct(id)).thenReturn("{\"message\":\"Product removed successfully , ID : "+id+"\"}");
		
		RequestBuilder requestbuilder=MockMvcRequestBuilders.delete("/delete/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockmvc.perform(requestbuilder).andReturn();
		int status=result.getResponse().getStatus();
		
		String expected="{\"message\":\"Product removed successfully , ID : "+id+"\"}";
		assertEquals(expected, result.getResponse().getContentAsString());
		verify(service,times(1)).deleteProduct(id);
		assertEquals(200, status);
	}
	
	@Test
	public void addProductTest() throws Exception {
		when(service.create(p)).thenReturn(p);
		String input="{\"id\":1,\"name\":\"Television\",\"quantity\":14,\"price\":23000}";
		
		RequestBuilder requestbuilder=MockMvcRequestBuilders.post("/create").accept(MediaType.APPLICATION_JSON)
				.content(input).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockmvc.perform(requestbuilder).andReturn();
		int status=result.getResponse().getStatus();
		
		String expected="{\"id\":1,\"name\":\"Television\",\"quantity\":14,\"price\":23000}";
		assertEquals(expected, result.getResponse().getContentAsString());
		verify(service,times(1)).create(p);
		assertEquals(200, status);
	}
	
	@Test
	public void addProductsTest() throws Exception {
		List<Product> p_list=new ArrayList<>();
		p_list.add(p);
		when(service.createproducts(p_list)).thenReturn(p_list);
		String input="[{\"id\":1,\"name\":\"Television\",\"quantity\":14,\"price\":23000}]";
		
		RequestBuilder requestbuiler=MockMvcRequestBuilders.post("/createProducts").accept(MediaType.APPLICATION_JSON)
				.content(input).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockmvc.perform(requestbuiler).andReturn();
		int status=result.getResponse().getStatus();
		
		String expected="[{\"id\":1,\"name\":\"Television\",\"quantity\":14,\"price\":23000}]";
		assertEquals(expected,result.getResponse().getContentAsString());
		verify(service,times(1)).createproducts(p_list);
		assertEquals(200, status);
		
	}
	
	@Test
	public void updateProductTest() throws Exception {
		
		Product updated_p=new Product(p.getId(), p.getName(), p.getQuantity(), 18000);
		String request_body="{\"id\":1,\"name\":\"Television\",\"quantity\":14,\"price\":23000}";
		when(service.updateProduct(p)).thenReturn(updated_p);
		
		
		RequestBuilder requestbuilder=MockMvcRequestBuilders.put("/update/1").accept(MediaType.APPLICATION_JSON)
				.content(request_body).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockmvc.perform(requestbuilder).andReturn();
		int status=result.getResponse().getStatus();
		
		String expected="{\"id\":1,\"name\":\"Television\",\"quantity\":14,\"price\":18000}";
		assertEquals(expected,result.getResponse().getContentAsString());
		verify(service,times(1)).updateProduct(p);
		assertEquals(200, status);
	}
	
}
