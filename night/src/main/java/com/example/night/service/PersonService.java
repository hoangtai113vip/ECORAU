package com.example.night.service;

import java.util.List;


import com.example.night.model.Person;


public interface PersonService {
	public List<Person> getPeople();

	public void savePerson(Person thePerson);

	public Person getPerson(long theId);

	public void deletePerson(long theId);
}
