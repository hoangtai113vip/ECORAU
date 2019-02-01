package com.example.night.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.night.model.Staff;


@Repository
public class StaffDAOImpl implements StaffDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Staff> getStaffs() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Staff> theQuery = 
				currentSession.createQuery("from Staff",
											Staff.class);
		
		// execute query and get result list
		List<Staff> staff = theQuery.getResultList();
				
		// return the results		
		return staff;
	}

	@Override
	public void saveStaff(Staff theStaff) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theStaff);
		
	}

	@Override
	public Staff getStaff(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Staff theStaff = currentSession.get(Staff.class, theId);
		
		return theStaff;
	}

	@Override
	public void deleteStaff(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Staff where id=:staffId");
		theQuery.setParameter("staffId", theId);
		
		theQuery.executeUpdate();		
	}

}