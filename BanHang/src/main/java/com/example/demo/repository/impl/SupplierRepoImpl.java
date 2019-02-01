package com.example.demo.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Supplier;

import com.example.demo.repository.SupplierRepo;


@Repository
public class SupplierRepoImpl implements SupplierRepo {
	
	@Autowired
	SessionFactory SessionFactory;
	
	@Override
	public List<Supplier> getAll() {
		Session currentSession = SessionFactory.getCurrentSession();
		
		Query<Supplier> query = currentSession.createQuery("from Supplier ",
				Supplier.class);
		List<Supplier> pro = query.getResultList();
		
		return pro;
	}

	@Override
	public void update(Supplier supplier) {
		Session currentSession = SessionFactory.getCurrentSession();
		currentSession.update(supplier);
		
	}

	@Override
	public Supplier getOne(int id) {
		Session currentSession = SessionFactory.getCurrentSession();
		Supplier pro =currentSession.get(Supplier.class, id);
		return pro;
	}

	@Override
	public void delete(int id) {
		Session currentSession = SessionFactory.getCurrentSession();
		//delete supplier
		Query query = currentSession.createQuery("delete From Supplier cate Where cate.supplierId=:id ");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	public void add(Supplier supplier) {
		Session currentSession = SessionFactory.getCurrentSession();
		currentSession.save(supplier);
		
	}
	

}
