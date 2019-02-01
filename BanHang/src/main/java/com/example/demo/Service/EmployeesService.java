package com.example.demo.Service;

import java.util.List;



import com.example.demo.model.Employees;



public interface EmployeesService {
	public List<Employees> getAll();

	public void update(Employees employees );

	public Employees getOne(int id);

	public void delete(int id);
	public void add(Employees employees);
}
