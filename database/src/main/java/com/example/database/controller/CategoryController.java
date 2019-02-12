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

import com.example.database.entity.Category;
import com.example.database.repository.CategoryRepostory;

@RestController
public class CategoryController {
	@Autowired
	CategoryRepostory repo;
	@GetMapping("/category")
	public List<Category> getAll(){
		return repo.getAll();
		
	}
	@PostMapping("/category")
	public String add(@RequestBody Category category)
	{
		repo.add(category);
		return "success";
	}
	@PutMapping("/category")
	public String update(@RequestBody Category category)
	{
		repo.add(category);
		return "success";
	}
	@GetMapping("/category/{id}")
	public Category getOne(@PathVariable int id)
	{
		
		return repo.getOne(id);
		
	}
	@DeleteMapping("/category/{id}")
	public String delete(@PathVariable int id)
	{
		Category category = repo.getOne(id);
		if(category==null) {
			throw new RuntimeException("not found category");
		}
		
		repo.delete(category);
		return "delete success";
		
	}
	
}
