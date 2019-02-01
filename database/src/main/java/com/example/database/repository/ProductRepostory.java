package com.example.database.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.database.entity.Product;

@Repository
@Transactional
public class ProductRepostory {
	@Autowired
	EntityManager em;
	
	

	
	public List<Product> getAll(){
		
		TypedQuery<Product> query = em.createQuery("from Product  pro ",Product.class);
		query.setFirstResult(0);
		query.setMaxResults(5);
	
		List<Product> products = query.getResultList();
		
		
		
		return products;
		
		
	}
	public Product getOne(int id) {
		return em.find(Product.class, id);
		
	}
	public void add(Product product)
	{
		em.merge(product);
	
	}
	public void  update(Product product) {
		em.persist(product);
	}
	public void delete(Product product) {
		em.remove(product);
	
		
	}
	
}
