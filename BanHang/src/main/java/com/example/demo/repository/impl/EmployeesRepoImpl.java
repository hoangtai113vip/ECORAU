package com.example.demo.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employees;

import com.example.demo.repository.EmployeesRepo;


@Repository
public class EmployeesRepoImpl implements EmployeesRepo {
	
	@Autowired
	SessionFactory SessionFactory;
	
	@Override
	public List<Employees> getAll() {
		Session currentSession = SessionFactory.getCurrentSession();
		
		Query<Employees> query = currentSession.createQuery("from Employees ",
				Employees.class);
		List<Employees> pro = query.getResultList();
		
		return pro;
	}

	@Override
	public void update(Employees employees) {
		Session currentSession = SessionFactory.getCurrentSession();
		currentSession.update(employees);
		
	}

	@Override
	public Employees getOne(int id) {
		Session currentSession = SessionFactory.getCurrentSession();
		Employees pro =currentSession.get(Employees.class, id);
		return pro;
	}

	@Override
	public void delete(int id) {
		Session currentSession = SessionFactory.getCurrentSession();
		//delete employees
		Query query = currentSession.createQuery("delete From Employees cate Where cate.employeesId=:id ");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	public void add(Employees employees) {
		Session currentSession = SessionFactory.getCurrentSession();
		currentSession.save(employees);
		
	}
	

}
