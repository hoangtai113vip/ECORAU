package com.example.demo.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customers;

import com.example.demo.repository.CustomersRepo;


@Repository
public class CustomersRepoImpl implements CustomersRepo {
	
	@Autowired
	SessionFactory SessionFactory;
	
	@Override
	public List<Customers> getAll() {
		Session currentSession = SessionFactory.getCurrentSession();
		
		Query<Customers> query = currentSession.createQuery("from Customers ",
				Customers.class);
		List<Customers> pro = query.getResultList();
		
		return pro;
	}

	@Override
	public void update(Customers customers) {
		Session currentSession = SessionFactory.getCurrentSession();
		currentSession.update(customers);
		
	}

	@Override
	public Customers getOne(int id) {
		Session currentSession = SessionFactory.getCurrentSession();
		Customers pro =currentSession.get(Customers.class, id);
		return pro;
	}

	@Override
	public void delete(int id) {
		Session currentSession = SessionFactory.getCurrentSession();
		//delete customers
		Query query = currentSession.createQuery("delete From Customers cate Where cate.customersId=:id ");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	public void add(Customers customers) {
		Session currentSession = SessionFactory.getCurrentSession();
		currentSession.save(customers);
		
	}
	

}
