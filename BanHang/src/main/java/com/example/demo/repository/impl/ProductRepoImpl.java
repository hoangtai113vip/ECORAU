package com.example.demo.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Repository
public class ProductRepoImpl implements ProductRepo {
	
	@Autowired
	SessionFactory SessionFactory;
	
	@Override
	public List<Product> getAll() {
		Session currentSession = SessionFactory.getCurrentSession();
		
		Query<Product> query = currentSession.createQuery("from Product",
				Product.class);
		List<Product> pro = query.getResultList();
		
		return pro;
	}

	@Override
	public void update(Product pro) {
		Session currentSession = SessionFactory.getCurrentSession();
		currentSession.update(pro);
		
	}

	@Override
	public Product getOne(int id) {
		Session currentSession = SessionFactory.getCurrentSession();
		Product pro =currentSession.get(Product.class, id);
		return pro;
	}

	@Override
	public void delete(int id) {
		Session currentSession = SessionFactory.getCurrentSession();
		//delete product 
		Query query = currentSession.createQuery("delete From Product pro Where pro.productId=:id ");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	public void add(Product pro) {
		Session currentSession = SessionFactory.getCurrentSession();
		currentSession.save(pro);
		
	}
	

}
