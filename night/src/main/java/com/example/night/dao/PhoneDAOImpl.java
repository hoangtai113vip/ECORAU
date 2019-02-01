package com.example.night.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.night.model.Customer;
import com.example.night.model.Phone;

@Repository
public class PhoneDAOImpl implements PhoneDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Phone> getPhone() {
		Session sessionCurrent = sessionFactory.getCurrentSession();
		Query<Phone> theQuery = 
				sessionCurrent.createQuery( "select ph from Phone ph join ph.person per " 
					   ,Phone.class);
		List<Phone> phones = theQuery.getResultList();
		return phones;
	}

	@Override
	public void savePhone(Phone thePhone) {
		// TODO Auto-generated method stub
		
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
			
				// save/upate the customer ... finally LOL
				currentSession.saveOrUpdate(thePhone);
				
		
	}
	
	@Override
	public Phone getPhone(long theId) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// now retrieve/read from database using the primary key
				Phone thePhone = currentSession.get(Phone.class, theId);
				
				return thePhone;
	}

	@Override
	public void deletePhone(long theId) {
		// TODO Auto-generated method stub
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// delete object with primary key
				Query theQuery = 
						currentSession.createQuery("delete from Phone where id=:theId");
				theQuery.setParameter("theId", theId);
				
				theQuery.executeUpdate();	
		
	}

	@Override
	public void addPhone(Phone thePhone) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(thePhone);
		
	}



}
