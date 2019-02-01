package com.example.demo.Service;

import java.util.List;



import com.example.demo.model.Category;



public interface CategoryService {
	public List<Category> getAll();

	public void update(Category cate);

	public Category getOne(int id);

	public void delete(int id);
	public void add(Category cate);
}
