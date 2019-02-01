package com.example.demo.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;

import com.example.demo.repository.CategoryRepo;


@Repository
public class CategoryRepoImpl implements CategoryRepo {
	
	@Autowired
	SessionFactory SessionFactory;
	
	@Override
	public List<Category> getAll() {
		Session currentSession = SessionFactory.getCurrentSession();
		
		Query<Category> query = currentSession.createQuery("from Category ",
				Category.class);
		List<Category> pro = query.getResultList();
		
		return pro;
	}

	@Override
	public void update(Category cate) {
		Session currentSession = SessionFactory.getCurrentSession();
		currentSession.update(cate);
		
	}

	@Override
	public Category getOne(int id) {
		Session currentSession = SessionFactory.getCurrentSession();
		Category pro =currentSession.get(Category.class, id);
		return pro;
	}

	@Override
	public void delete(int id) {
		Session currentSession = SessionFactory.getCurrentSession();
		//delete category
		Query query = currentSession.createQuery("delete From Category cate Where cate.categoryId=:id ");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	@Override
	public void add(Category cate) {
		Session currentSession = SessionFactory.getCurrentSession();
		currentSession.save(cate);
		
	}
	

}
