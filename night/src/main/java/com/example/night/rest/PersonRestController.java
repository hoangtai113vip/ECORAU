package com.example.night.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.night.model.Person;
import com.example.night.model.Person;
import com.example.night.service.PersonService;
import com.example.night.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonRestController {
	
	// autowire the PersonService
		@Autowired
		private PersonService personService ;
		
	
		// add mapping for GET /Persons
		@GetMapping("/person")
		public List<Person> getPersons() {
			
			return personService.getPeople();
			
		}
		
		// add mapping for GET /Persons/{PersonId}
		
		@GetMapping("/person/{PersonId}")
		public Person getPerson(@PathVariable int PersonId) {
			
			Person thePerson = personService.getPerson(PersonId);
			
			if (thePerson == null) {
				throw new CustomerNotFoundException("Person id not found - " + PersonId);
			}
			
			return thePerson;
		}
		
		// add mapping for POST /Persons  - add new Person
		
		@PostMapping("/person")
		public Person addPerson(@RequestBody Person thePerson) {
			
			// also just in case the pass an id in JSON ... set id to 0
			// this is force a save of new item ... instead of update
			
			thePerson.setId(0L);
		
			
			
			personService.savePerson(thePerson);
			
			return thePerson;
			
//			if(thePerson.getId() == 0){
//				//new person, add it
//				this.PersonService.addPerson(thePerson);
//			}else{
//				//existing person, call update
//				this.PersonService.savePerson(thePerson);
//			}
//			return thePerson;
			
		}
		
		// add mapping for PUT /Persons - update existing Person
		
		@PutMapping("/person")
		public Person updatePerson(@RequestBody Person thePerson) {
			
			personService.savePerson(thePerson);
			
			return thePerson;
			
		}
		
		// add mapping for DELETE /Persons/{PersonId} - delete Person
		
		@DeleteMapping("/person/{PersonId}")
		public String deletePerson(@PathVariable long PersonId) {
			
			Person tempPerson = personService.getPerson(PersonId);
			
			// throw exception if null
			
			if (tempPerson == null) {
//				throw new PersonNotFoundException("Person id not found - " + PersonId);
				return "fail";
			}
					
			personService.deletePerson(PersonId);
			
			return "Deleted Person id - " + PersonId;
		}
		
	}


