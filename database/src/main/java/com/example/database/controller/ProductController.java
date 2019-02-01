package com.example.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.entity.Product;
import com.example.database.repository.ProductRepostory;

@RestController
public class ProductController {
	@Autowired
	ProductRepostory repo;
	@GetMapping("/product")
	public List<Product> getAll(){
		return repo.getAll();
		
	}
	@PostMapping("/product")
	public String add(@RequestBody Product product)
	{
		repo.add(product);
		return "success";
	}
	@PutMapping("/product")
	public String update(@RequestBody Product product)
	{
		repo.add(product);
		return "success";
	}
	@GetMapping("/product/{id}")
	public Product getOne(@PathVariable int id)
	{
		
		return repo.getOne(id);
		
	}
	@DeleteMapping("/product/{id}")
	public String delete(@PathVariable int id)
	{
		Product product = repo.getOne(id);
		if(product==null) {
			throw new RuntimeException("not found product");
		}
		
		repo.delete(product);
		return "delete success";
		
	}
	
}
