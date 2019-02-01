package com.example.night.dao;

import java.util.List;

import com.example.night.model.Customer;
import com.example.night.model.Person;

public interface PersonDAO {
	public List<Person> getPeople();

	public void savePerson(Person thePerson);

	public Person getPerson(long theId);

	public void deletePerson(long theId);
}
