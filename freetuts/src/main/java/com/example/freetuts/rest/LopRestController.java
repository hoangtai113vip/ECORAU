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

import com.example.freetuts.model.Lop;
import com.example.freetuts.service.LopService;
import com.example.freetuts.service.SinhVienService;



@RestController
@RequestMapping("/api")
public class LopRestController {

	// autowire the LopService
	@Autowired
	private LopService lopService;
	
	


	// add mapping for GET /lops
	@GetMapping("/lop")
	public List<Lop> getLops() {
		
		return lopService.getLops();
		
	}
	
	// add mapping for GET /lops/{lopId}
	
	@GetMapping("/lop/{lopId}")
	public Lop getLop(@PathVariable int lopId) {
		
		Lop theLop = lopService.getLop(lopId);
		
		if (theLop == null) {
			throw new FreetutNotFoundException("Lop id not found - " + lopId);
		}
		
		return theLop;
	}
	
	// add mapping for POST /lops  - add new lop
	
	@PostMapping("/lop")
	public Lop addLop(@RequestBody Lop theLop) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theLop.setMaLop(0);
		
		lopService.addLop(theLop);;
		
		return theLop;
	}
	
	// add mapping for PUT /lops - update existing lop
	
	@PutMapping("/lop")
	public Lop updateLop(@RequestBody Lop theLop) {
		
		lopService.saveLop(theLop);
		
		return theLop;
		
	}
	
	// add mapping for DELETE /lops/{lopId} - delete lop
	
	@DeleteMapping("/lop/{lopId}")
	public String deleteLop(@PathVariable int lopId) {
		
		Lop tempLop = lopService.getLop(lopId);
		
		// throw exception if null
		
		if (tempLop == null) {
			throw new FreetutNotFoundException("Lop id not found - " + lopId);
		}
				
		lopService.deleteLop(lopId);
		
		return "Deleted lop id - " + lopId;
	}
	
	
	
}


















