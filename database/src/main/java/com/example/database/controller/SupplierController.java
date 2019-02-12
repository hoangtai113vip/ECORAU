package com.example.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.entity.Supplier;
import com.example.database.repository.SupplierRepository;


@RestController
public class SupplierController {
	@Autowired
	SupplierRepository repo;
	@GetMapping("/supplier")
	public List<Supplier> getAll(){
		return repo.getAll();
		
	}
	@PostMapping("/supplier")
	public String add(@RequestBody Supplier supplier)
	{
		repo.add(supplier);
		return "success";
	}
	@PutMapping("/supplier")
	public String update(@RequestBody Supplier supplier)
	{
		repo.add(supplier);
		return "success";
	}
	@GetMapping("/supplier/{id}")
	public Supplier getOne(@PathVariable int id)
	{
		
		return repo.getOne(id);
		
	}
	@DeleteMapping("/supplier/{id}")
	public String delete(@PathVariable int id)
	{
		Supplier supplier = repo.getOne(id);
		if(supplier==null) {
			throw new RuntimeException("not found supplier");
		}
		
		repo.delete(supplier);
		return "delete success";
		
	}
	
}
