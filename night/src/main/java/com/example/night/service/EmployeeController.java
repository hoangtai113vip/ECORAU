package com.example.night.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.night.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping("/employee")
	@Transactional
	public Employee getEmployee(){
		Session ss =sessionFactory.getCurrentSession();
		Query<Employee> query =  ss.createQuery("from Employee",Employee.class);
		Employee em =query.getSingleResult();
		return em;
		
	}
	

}
