package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Supplier;


public interface SupplierRepo {
	public List<Supplier> getAll();

	public void update(Supplier supplier);

	public Supplier getOne(int id);

	public void delete(int id);
	public void add(Supplier supplier);
}
