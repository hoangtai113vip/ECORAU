package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Category;
import com.example.demo.model.Product;


public interface CategoryRepo {
	public List<Category> getAll();

	public void update(Category category);

	public Category getOne(int id);

	public void delete(int id);
	public void add(Category category);
}
