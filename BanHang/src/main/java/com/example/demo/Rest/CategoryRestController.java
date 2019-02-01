package com.example.demo.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CategoryService;
import com.example.demo.model.Category;

@RestController
@RequestMapping("/category")
public class CategoryRestController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("")
	public List<Category> getAll(){
		
		return categoryService.getAll();
		
	}
	@GetMapping("/{id}")
	public Category getOne(@PathVariable int id ) {
		Category category = categoryService.getOne(id);
		if(categoryService==null) {
			throw new BanHangException("category not exist");
		}
		return category;
	}
	@PostMapping("")
	public Category add(@RequestBody Category category) {
		category.setCategoryId(0);
		categoryService.add(category);
		return category;
	}
	@PutMapping("")
	public Category update(@RequestBody Category category)
	{
		categoryService.update(category);
		return category;
	}
	
	@DeleteMapping("/{id}")
	public String delete(int id)
	{
		Category category = categoryService.getOne(id);
		if(category==null) {
			throw new BanHangException("categoryService not exist");
			
		}
		categoryService.delete(id);
		return "delete success";
	}


}
