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

import com.example.database.entity.OrderDetails;
import com.example.database.repository.OrderDetailsRepository;


@RestController
public class OrderDetailsController {
	@Autowired
	OrderDetailsRepository repo;
	@GetMapping("/orderdetails")
	public List<OrderDetails> getAll(){
		return repo.getAll();
		
	}
	@PostMapping("/orderdetails")
	public String add(@RequestBody OrderDetails orderDetails)
	{
		repo.add(orderDetails);
		return "success";
	}
	@PutMapping("/orderdetails")
	public String update(@RequestBody OrderDetails orderDetails)
	{
		repo.add(orderDetails);
		return "success";
	}
	@GetMapping("/orderdetails/{id}")
	public OrderDetails getOne(@PathVariable int id)
	{
		
		return repo.getOne(id);
		
	}
	@DeleteMapping("/orderdetails/{id}")
	public String delete(@PathVariable int id)
	{
		OrderDetails orderDetails = repo.getOne(id);
		if(orderDetails==null) {
			throw new RuntimeException("not found oderdetail");
		}
		
		repo.delete(orderDetails);
		return "delete success";
		
	}
	@GetMapping("orderdetails/order/{id}")
	public List<OrderDetails> getByOrderId(@PathVariable int id){
		return repo.getByOrderId(id);
	}
	@GetMapping("orderdetails/details")
	public List<Object[]> getDetail(){
		return repo.getDetailObject();
	}
	
}
