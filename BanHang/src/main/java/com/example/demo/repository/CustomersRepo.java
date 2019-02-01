package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Customers;


public interface CustomersRepo {
	public List<Customers> getAll();

	public void update(Customers customers);

	public Customers getOne(int id);

	public void delete(int id);
	public void add(Customers customers);
}
