package com.example.database.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.database.entity.Category;

@Repository
@Transactional
public class CategoryRepostory {
	@Autowired
	EntityManager em;
	
	

	
	public List<Category> getAll(){
		
		TypedQuery<Category> query = em.createQuery("from Category  pro ",Category.class);
		query.setFirstResult(0);
		query.setMaxResults(5);
	
		List<Category> categorys = query.getResultList();
		
		
		
		return categorys;
		
		
	}
	public Category getOne(int id) {
		return em.find(Category.class, id);
		
	}
	public void add(Category category)
	{
		em.merge(category);
	
	}
	public void  update(Category category) {
		em.persist(category);
	}
	public void delete(Category category) {
		em.remove(category);
	
		
	}
	
}
