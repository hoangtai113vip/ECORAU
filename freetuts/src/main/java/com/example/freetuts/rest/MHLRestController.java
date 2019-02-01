package com.example.freetuts.rest;

import java.util.List;

import javax.persistence.Tuple;

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
import com.example.freetuts.model.MonhocLop;
import com.example.freetuts.service.LopService;
import com.example.freetuts.service.MonhocLopService;
import com.example.freetuts.service.SinhVienService;



@RestController
@RequestMapping("/api")
public class MHLRestController {

	// autowire mon hoc lop service
	@Autowired
	private MonhocLopService mhlService;
	
	


	// add mapping for GET /mhls
	@GetMapping("/mhl")
	public List<MonhocLop> getMHL() {
		
		return mhlService.getMonhocLop();
		
	}
	
	// add mapping for GET /mhls/{mhlId}
	
	@GetMapping("/mhl/{maMh}&{maLop}")
	public MonhocLop getMHL(@PathVariable int maMh,@PathVariable int maLop) {
		
		 MonhocLop mhl = mhlService.getMonhocLop(maMh,maLop);
		
		if (mhl == null) {
			throw new FreetutNotFoundException("Lop id not found - ");
		}
		
		return mhl;
	}
	
	// add mapping for POST /mhls  - add new mhl
	
	@PostMapping("/mhl")
	public MonhocLop addLop(@RequestBody MonhocLop mhl) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		
		mhlService.addMonhocLop(mhl);
		
		return mhl;
	}
	
	// add mapping for PUT /mhls - update existing mhl
	
	@PutMapping("/mhl")
	public MonhocLop updateLop(@RequestBody MonhocLop mhl) {
		
		mhlService.saveMonhocLop(mhl);
		
		return mhl;
		
	}
	
	// add mapping for DELETE /mhls/{mhlId} - delete mhl
	
	@DeleteMapping("/mhl/{maMh}&{maLop}")
	public String deleteMHL(@PathVariable int maMh,@PathVariable int maLop) {
		
		MonhocLop tempLop = mhlService.getMonhocLop(maMh,maLop);
		
		// throw exception if null
		
		if (tempLop == null) {
			throw new FreetutNotFoundException("Lop id not found - ");
		}
				
		mhlService.deleteMonhocLop(maMh,maLop);
		
		return "Deleted mhl id - " + maMh+" ,"+maLop;
	}
	
	@GetMapping("/mhl/join")
	public List<Object[]> getMHLJoinTable() {
		
		return mhlService.getJoinTable();
		
	}
	
	
	
	
}


















