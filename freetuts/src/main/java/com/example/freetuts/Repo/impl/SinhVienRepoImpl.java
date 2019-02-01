package com.example.freetuts.Repo.impl;

import java.beans.Customizer;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.freetuts.Repo.SinhVienRepo;
import com.example.freetuts.model.Sinhvien;



@Repository
public class SinhVienRepoImpl implements SinhVienRepo {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Sinhvien> getSinhviens(int start) {
	
		start= start*5;
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Sinhvien> theQuery = 
				currentSession.createQuery(" from Sinhvien sv  ",
											Sinhvien.class);

	
		theQuery.setFirstResult(start);
		theQuery.setMaxResults(5);
		
		// execute query and get result list
		List<Sinhvien> Sinhviens = theQuery.getResultList();
				
		// return the results		
		return Sinhviens;
	}

	@Override
	public void saveSinhvien(Sinhvien theSinhvien) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the Sinhvien ... finally LOL
		currentSession.saveOrUpdate(theSinhvien);
		
	}
	public void addSinhvien(Sinhvien sv) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(sv);
	}

	@Override
	public Sinhvien getSinhvien(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Sinhvien theSinhvien = currentSession.get(Sinhvien.class, theId);
		
		return theSinhvien;
	}

	@Override
	public void deleteSinhvien(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Sinhvien where MaSV=:SinhvienId");
		theQuery.setParameter("SinhvienId", theId);
		
		theQuery.executeUpdate();		
	}

}