package com.example.freetuts.rest;

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

import com.example.freetuts.model.MonHoc;
import com.example.freetuts.service.MonHocService;
import com.example.freetuts.service.SinhVienService;



@RestController
@RequestMapping("/api")
public class MonHocRestController {

	// autowire the MonHocService
	@Autowired
	private MonHocService monhocService;
	
	


	// add mapping for GET /monhocs
	@GetMapping("/monhoc")
	public List<MonHoc> getMonHocs() {
		
		return monhocService.getMonHocs();
		
	}
	
	// add mapping for GET /monhocs/{monhocId}
	
	@GetMapping("/monhoc/{monhocId}")
	public MonHoc getMonHoc(@PathVariable int monhocId) {
		
		MonHoc theMonHoc = monhocService.getMonHoc(monhocId);
		
		if (theMonHoc == null) {
			throw new FreetutNotFoundException("MonHoc id not found - " + monhocId);
		}
		
		return theMonHoc;
	}
	
	// add mapping for POST /monhocs  - add new monhoc
	
	@PostMapping("/monhoc")
	public MonHoc addMonHoc(@RequestBody MonHoc theMonHoc) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theMonHoc.setMaMh(0);
		
		monhocService.addMonHoc(theMonHoc);;
		
		return theMonHoc;
	}
	
	// add mapping for PUT /monhocs - update existing monhoc
	
	@PutMapping("/monhoc")
	public MonHoc updateMonHoc(@RequestBody MonHoc theMonHoc) {
		
		monhocService.saveMonHoc(theMonHoc);
		
		return theMonHoc;
		
	}
	
	// add mapping for DELETE /monhocs/{monhocId} - delete monhoc
	
	@DeleteMapping("/monhoc/{monhocId}")
	public String deleteMonHoc(@PathVariable int monhocId) {
		
		MonHoc tempMonHoc = monhocService.getMonHoc(monhocId);
		
		// throw exception if null
		
		if (tempMonHoc == null) {
			throw new FreetutNotFoundException("MonHoc id not found - " + monhocId);
		}
				
		monhocService.deleteMonHoc(monhocId);
		
		return "Deleted monhoc id - " + monhocId;
	}
	
	
	
}


















