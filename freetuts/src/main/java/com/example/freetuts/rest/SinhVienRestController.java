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

import com.example.freetuts.model.Sinhvien;
import com.example.freetuts.service.SinhVienService;



@RestController
@RequestMapping("/api")
public class SinhVienRestController {

	// autowire the SinhvienService
	@Autowired
	private SinhVienService sinhvienService;
	
	


	// add mapping for GET /sinhviens
	@GetMapping("/sinhvien/all/{start}")
	public List<Sinhvien> getSinhviens(@PathVariable(value="start") int start) {
		
		
		return sinhvienService.getSinhviens(start);
		
	}
	
	// add mapping for GET /sinhviens
		@GetMapping("/sinhvien")
		public List<Sinhvien> getSinhviens() {
			
			int start =0;
			return sinhvienService.getSinhviens(start);
			
		}
	
	// add mapping for GET /sinhviens/{sinhvienId}
	
	@GetMapping("/sinhvien/{sinhvienId}")
	public Sinhvien getSinhvien(@PathVariable int sinhvienId) {
		
		Sinhvien theSinhvien = sinhvienService.getSinhvien(sinhvienId);
		
		if (theSinhvien == null) {
			throw new FreetutNotFoundException("Sinhvien id not found - " + sinhvienId);
		}
		
		return theSinhvien;
	}
	
	// add mapping for POST /sinhviens  - add new sinhvien
	
	@PostMapping("/sinhvien")
	public Sinhvien addSinhvien(@RequestBody Sinhvien theSinhvien) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theSinhvien.setMaSv(0);
		
		sinhvienService.addSinhvien(theSinhvien);;
		
		return theSinhvien;
	}
	
	// add mapping for PUT /sinhviens - update existing sinhvien
	
	@PutMapping("/sinhvien")
	public Sinhvien updateSinhvien(@RequestBody Sinhvien theSinhvien) {
		
		sinhvienService.saveSinhvien(theSinhvien);
		
		return theSinhvien;
		
	}
	
	// add mapping for DELETE /sinhviens/{sinhvienId} - delete sinhvien
	
	@DeleteMapping("/sinhvien/{sinhvienId}")
	public String deleteSinhvien(@PathVariable int sinhvienId) {
		
		Sinhvien tempSinhvien = sinhvienService.getSinhvien(sinhvienId);
		
		// throw exception if null
		
		if (tempSinhvien == null) {
			throw new FreetutNotFoundException("Sinhvien id not found - " + sinhvienId);
		}
				
		sinhvienService.deleteSinhvien(sinhvienId);
		
		return "Deleted sinhvien id - " + sinhvienId;
	}
	
	
	
}


















