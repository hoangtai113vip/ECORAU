package com.example.freetuts.Repo.impl;

import java.beans.Customizer;
import java.util.List;

import javax.persistence.Tuple;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.freetuts.Repo.MonhocLopRepo;
import com.example.freetuts.model.MonhocLop;



@Repository
public class MonhocLopRepoImpl implements MonhocLopRepo
{

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<MonhocLop> getMonhocLop(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<MonhocLop> theQuery = 
				currentSession.createQuery("from MonhocLop",
											MonhocLop.class);
		
		// execute query and get result list
		List<MonhocLop> MonhocLops = theQuery.getResultList();
				
		// return the results		
		return MonhocLops;
	}

	@Override
	public void saveMonhocLop(MonhocLop theMonhocLop) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the MonhocLop ... finally LOL
		currentSession.saveOrUpdate(theMonhocLop);
		
	}
	public void addMonhocLop(MonhocLop lop) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(lop);
	}

	@Override
	public MonhocLop getMonhocLop(int maMh,int maLop) {

		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
				// create a query  ... sort by last name
				Query<MonhocLop> theQuery = 
						currentSession.createQuery("from MonhocLop mhl where mhl.maMh=:maMh and mhl.maLop=:maLop",
													MonhocLop.class);
				theQuery.setParameter("maMh", maMh);
				theQuery.setParameter("maMh", maLop);
				
				// execute query and get result list
				MonhocLop MonhocLop = theQuery.getSingleResult();
				return MonhocLop;
	}

	@Override
	public void deleteMonhocLop(int maMh,int maLop) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from MonhocLop mhl where mhl.maMh=:maMh and mhl.maLop=:maLop");
		theQuery.setParameter("maMh", maMh);
		theQuery.setParameter("maMh", maLop);
		
		theQuery.executeUpdate();		
	}
	
	@Override 
	public List<Object[]> getJoinTable(){
		Session currentSession = sessionFactory.getCurrentSession();
		List<Object[]> monhoclop = currentSession.createQuery(
			    "select mpl.maMh,mh.tenMh,lop " +
			    "from MonhocLop mpl " +
			    "Inner join MonHoc mh on mpl.maMh = mh.maMh"+
			    " Inner join Lop lop on mpl.maLop = lop.maLop")
			.list();
			 
		return monhoclop;
	}

}