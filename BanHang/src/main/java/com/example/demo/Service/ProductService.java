package com.example.demo.Service;

import java.util.List;



import com.example.demo.model.Product;



public interface ProductService {
	public List<Product> getAll();

	public void update(Product pro);

	public Product getOne(int id);

	public void delete(int id);
	public void add(Product pro);
}
