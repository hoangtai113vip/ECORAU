package com.example.night.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.night.dao.PersonDAO;
import com.example.night.model.Customer;
import com.example.night.model.Person;


@Service
public class PersonServiceImpl implements PersonService {

	// need to inject customer dao
		@Autowired
		private PersonDAO personDAO;
		
		@Override
		@Transactional
		public List<Person> getPeople() {
			return personDAO.getPeople();
		}

		@Override
		@Transactional
		public void savePerson(Person thePerson) {

			personDAO.savePerson(thePerson);
		}

		@Override
		@Transactional
		public Person getPerson(long theId) {
			
			return personDAO.getPerson(theId);
		}

		@Override
		@Transactional
		public void deletePerson(long theId) {
			
			personDAO.deletePerson(theId);
		}

}
