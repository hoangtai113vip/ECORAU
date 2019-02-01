package com.example.night.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.night.model.Staff;
import com.example.night.service.StaffService;


@RestController
@RequestMapping("/api")
public class StaffRestController {

	// autowire the StaffService
	@Autowired
	private StaffService staffService;
	
	


	// add mapping for GET /staffs
	@GetMapping("/staffs")
	public List<Staff> getStaffs() {
		
		return staffService.getStaffs();
		
	}
	
	// add mapping for GET /staffs/{staffId}
	
	@GetMapping("/staffs/{staffId}")
	public Staff getStaff(@PathVariable int staffId) {
		
		Staff theStaff = staffService.getStaff(staffId);
		
		if (theStaff == null) {
			throw new CustomerNotFoundException("Staff id not found - " + staffId);
		}
		
		return theStaff;
	}
	
	// add mapping for POST /staffs  - add new staff
	
	@PostMapping("/staffs")
	public Staff addStaff(@RequestBody Staff theStaff) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theStaff.setId(0L);
		
		staffService.saveStaff(theStaff);
		
		return theStaff;
	}
	
	// add mapping for PUT /staffs - update existing staff
	
	@PutMapping("/staffs")
	public Staff updateStaff(@RequestBody Staff theStaff) {
		
		staffService.saveStaff(theStaff);
		
		return theStaff;
		
	}
	
	// add mapping for DELETE /staffs/{staffId} - delete staff
	
	@DeleteMapping("/staffs/{staffId}")
	public String deleteStaff(@PathVariable int staffId) {
		
		Staff tempStaff = staffService.getStaff(staffId);
		
		// throw exception if null
		
		if (tempStaff == null) {
			throw new CustomerNotFoundException("Staff id not found - " + staffId);
		}
				
		staffService.deleteStaff(staffId);
		
		return "Deleted staff id - " + staffId;
	}
	
}


















