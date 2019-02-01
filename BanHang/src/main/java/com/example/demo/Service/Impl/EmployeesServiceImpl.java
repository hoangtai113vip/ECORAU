package com.example.demo.Service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.EmployeesService;
import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeesRepo;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	EmployeesRepo employeesRepo;
	@Override
	@Transactional
	public List<Employees> getAll() {
	
		return employeesRepo.getAll();
	}

	@Override
	@Transactional
	public void update(Employees employees) {
		// TODO Auto-generated method stub
		employeesRepo.update(employees);
		
	}

	@Override
	@Transactional
	public Employees getOne(int id) {
		// TODO Auto-generated method stub
		return employeesRepo.getOne(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeesRepo.delete(id);
		
	}

	@Override
	@Transactional
	public void add(Employees employees) {
		// TODO Auto-generated method stub
		employeesRepo.add(employees);
		
	}

}
