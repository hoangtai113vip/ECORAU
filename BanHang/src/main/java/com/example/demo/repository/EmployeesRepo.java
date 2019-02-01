package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Employees;


public interface EmployeesRepo {
	public List<Employees> getAll();

	public void update(Employees employees);

	public Employees getOne(int id);

	public void delete(int id);
	public void add(Employees employees);
}
