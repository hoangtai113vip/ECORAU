package com.example.freetuts.Repo.impl;

import java.beans.Customizer;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.freetuts.Repo.LopRepo;
import com.example.freetuts.model.Lop;



@Repository
public class LopRepoImpl implements LopRepo
{

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Lop> getLops(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Lop> theQuery = 
				currentSession.createQuery("from Lop",
											Lop.class);
		
		// execute query and get result list
		List<Lop> Lops = theQuery.getResultList();
				
		// return the results		
		return Lops;
	}

	@Override
	public void saveLop(Lop theLop) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the Lop ... finally LOL
		currentSession.saveOrUpdate(theLop);
		
	}
	public void addLop(Lop lop) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(lop);
	}

	@Override
	public Lop getLop(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Lop theLop = currentSession.get(Lop.class, theId);
		
		return theLop;
	}

	@Override
	public void deleteLop(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Lop where ma_lop=:LopId");
		theQuery.setParameter("LopId", theId);
		
		theQuery.executeUpdate();		
	}

}