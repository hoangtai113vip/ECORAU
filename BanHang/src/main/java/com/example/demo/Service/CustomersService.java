package com.example.demo.Service;

import java.util.List;



import com.example.demo.model.Customers;



public interface CustomersService {
	public List<Customers> getAll();

	public void update(Customers customers );

	public Customers getOne(int id);

	public void delete(int id);
	public void add(Customers customers);
}
