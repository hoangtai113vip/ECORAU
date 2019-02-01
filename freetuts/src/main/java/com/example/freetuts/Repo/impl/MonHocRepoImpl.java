package com.example.freetuts.Repo.impl;

import java.beans.Customizer;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.freetuts.Repo.MonHocRepo;
import com.example.freetuts.model.MonHoc;



@Repository
public class MonHocRepoImpl implements MonHocRepo
{

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<MonHoc> getMonHocs(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<MonHoc> theQuery = 
				currentSession.createQuery("from MonHoc",
											MonHoc.class);
		
		// execute query and get result list
		List<MonHoc> MonHocs = theQuery.getResultList();
				
		// return the results		
		return MonHocs;
	}

	@Override
	public void saveMonHoc(MonHoc theMonHoc) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the MonHoc ... finally LOL
		currentSession.saveOrUpdate(theMonHoc);
		
	}
	public void addMonHoc(MonHoc mh) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(mh);
	}

	@Override
	public MonHoc getMonHoc(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		MonHoc theMonHoc = currentSession.get(MonHoc.class, theId);
		
		return theMonHoc;
	}

	@Override
	public void deleteMonHoc(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from MonHoc where Ma_mh=:MonHocId");
		theQuery.setParameter("MonHocId", theId);
		
		theQuery.executeUpdate();		
	}

}