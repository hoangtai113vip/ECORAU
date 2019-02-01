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

import com.example.demo.Service.EmployeesService;
import com.example.demo.model.Employees;

@RestController
@RequestMapping("/employees")
public class EmployeesRestController {
	
	@Autowired
	EmployeesService employeesService;
	
	@GetMapping("")
	public List<Employees> getAll(){
		
		return employeesService.getAll();
		
	}
	@GetMapping("/{id}")
	public Employees getOne(@PathVariable int id ) {
		Employees employees = employeesService.getOne(id);
		if(employeesService==null) {
			throw new BanHangException("employees not exist");
		}
		return employees;
	}
	@PostMapping("")
	public Employees add(@RequestBody Employees employees) {
		employees.setEmployeeId(0);
		employeesService.add(employees);
		return employees;
	}
	@PutMapping("")
	public Employees update(@RequestBody Employees employees)
	{
		employeesService.update(employees);
		return employees;
	}
	
	@DeleteMapping("/{id}")
	public String delete(int id)
	{
		Employees employees = employeesService.getOne(id);
		if(employees==null) {
			throw new BanHangException("employeesService not exist");
			
		}
		employeesService.delete(id);
		return "delete success";
	}


}
