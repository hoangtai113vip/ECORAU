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

import com.example.night.model.Phone;
import com.example.night.model.Phone;
import com.example.night.service.PhoneService;
import com.example.night.service.PhoneService;

@RestController
@RequestMapping("/api")
public class PhoneRestController {
	
	// autowire the PhoneService
		@Autowired
		private PhoneService phoneService ;
		
	
		// add mapping for GET /Phones
		@GetMapping("/phones")
		public List<Phone> getPhones() {
			
			return phoneService.getPhones();
			
		}
		
		// add mapping for GET /Phones/{PhoneId}
		
		@GetMapping("/phones/{PhoneId}")
		public Phone getPhone(@PathVariable long PhoneId) {
			
			Phone thePhone = phoneService.getPhone(PhoneId);
			
			if (thePhone == null) {
				throw new CustomerNotFoundException("Phone id not found - " + PhoneId);
			}
			
			return thePhone;
		}
		
		// add mapping for POST /Phones  - add new Phone
		
		@PostMapping("/phones")
		public Phone addPhone(@RequestBody Phone thePhone) {
			
			// also just in case the pass an id in JSON ... set id to 0
			// this is force a save of new item ... instead of update
			
			thePhone.setId(0);
		
			
			
			phoneService.savePhone(thePhone);
			
			return thePhone;
			
//			if(thePhone.getId() == 0){
//				//new person, add it
//				this.phoneService.addPhone(thePhone);
//			}else{
//				//existing person, call update
//				this.phoneService.savePhone(thePhone);
//			}
//			return thePhone;
			
		}
		
		// add mapping for PUT /Phones - update existing Phone
		
		@PutMapping("/phones")
		public Phone updatePhone(@RequestBody Phone thePhone) {
			
			phoneService.savePhone(thePhone);
			
			return thePhone;
			
		}
		
		// add mapping for DELETE /Phones/{PhoneId} - delete Phone
		
		@DeleteMapping("/phones/{PhoneId}")
		public String deletePhone(@PathVariable int PhoneId) {
			
			Phone tempPhone = phoneService.getPhone(PhoneId);
			
			// throw exception if null
			
			if (tempPhone == null) {
//				throw new PhoneNotFoundException("Phone id not found - " + PhoneId);
				return "fail";
			}
					
			phoneService.deletePhone(PhoneId);
			
			return "Deleted Phone id - " + PhoneId;
		}
		
	}


