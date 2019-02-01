package com.example.night.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.night.model.Customer;
import com.example.night.model.Person;
import com.example.night.model.Phone;

@Repository
public class PersonDAOImpl implements PersonDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Person> getPeople() {
		Session sessionCurrent = sessionFactory.getCurrentSession();
		Query<Person> theQuery = 
				sessionCurrent.createQuery( " from Person " ,Person.class);
		List<Person> people = theQuery.getResultList();
		return people;
	}

	@Override
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
			
				// save/upate the customer ... finally LOL
				currentSession.saveOrUpdate(person);
				
		
	}
	
	@Override
	public Person getPerson(long theId) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// now retrieve/read from database using the primary key
				Person person = currentSession.get(Person.class, theId);
				
				return person;
	}

	@Override
	public void deletePerson(long theId) {
		// TODO Auto-generated method stub
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// delete object with primary key
				Query theQuery = 
						currentSession.createQuery("delete from Person where id=:theId");
				theQuery.setParameter("theId", theId);
				
				theQuery.executeUpdate();	
		
	}


	
}
