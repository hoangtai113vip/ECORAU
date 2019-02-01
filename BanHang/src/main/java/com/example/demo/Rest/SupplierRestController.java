package com.example.demo.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.SupplierService;
import com.example.demo.model.Supplier;

@RestController
@RequestMapping("/supplier")
public class SupplierRestController {
	
	@Autowired
	SupplierService supplierService;
	
	@GetMapping("")
	public List<Supplier> getAll(){
		
		return supplierService.getAll();
		
	}
	@GetMapping("/{id}")
	public Supplier getOne(@PathVariable int id ) {
		Supplier supplier = supplierService.getOne(id);
		if(supplierService==null) {
			throw new BanHangException("supplier not exist");
		}
		return supplier;
	}
	@PostMapping("")
	public Supplier add(@RequestBody Supplier supplier) {
		supplier.setSupplierId(0);
		supplierService.add(supplier);
		return supplier;
	}
	@PutMapping("")
	public Supplier update(@RequestBody Supplier supplier)
	{
		supplierService.update(supplier);
		return supplier;
	}
	
	@DeleteMapping("/{id}")
	public String delete(int id)
	{
		Supplier supplier = supplierService.getOne(id);
		if(supplier==null) {
			throw new BanHangException("supplierService not exist");
			
		}
		supplierService.delete(id);
		return "delete success";
	}


}
