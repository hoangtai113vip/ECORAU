package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Product;


public interface ProductRepo {
	public List<Product> getAll();

	public void update(Product pro);

	public Product getOne(int id);

	public void delete(int id);
	public void add(Product pro);
}
