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

import com.example.freetuts.model.DiemThi;
import com.example.freetuts.service.DiemThiService;
import com.example.freetuts.service.SinhVienService;



@RestController
@RequestMapping("/api")
public class DiemThiRestController {

	// autowire the DiemThiService
	@Autowired
	private DiemThiService diemthiService;
	
	


	// add mapping for GET /diemthis
	@GetMapping("/diemthi")
	public List<DiemThi> getDiemThis() {
		
		return diemthiService.getDiemThi();
		
	}
	
	// add mapping for GET /diemthis/{diemthiId}
	
	@GetMapping("/diemthi/{maMh}&{maSV}")
	public DiemThi getDiemThi(@PathVariable int maMh,@PathVariable int maSV) {
		
		DiemThi theDiemThi = diemthiService.getDiemThi(maMh,maSV);
		
		if (theDiemThi == null) {
			throw new FreetutNotFoundException("DiemThi id not found - " );
		}
		
		return theDiemThi;
	}
	
	@GetMapping("/diemthi/monhoc/{maMh}")
	public List<DiemThi> getDiemThiMh(@PathVariable int maMh) {
		
		List<DiemThi> theDiemThi = diemthiService.getDiemThiMh(maMh);
		
		if (theDiemThi == null) {
			throw new FreetutNotFoundException("DiemThi id not found - " );
		}
		
		return theDiemThi;
	}
	@GetMapping("/diemthi/sinhvien/{maSV}")
	public List<DiemThi> getDiemThiSV(@PathVariable int maSV) {
		
		List<DiemThi> theDiemThi = diemthiService.getDiemThiSv(maSV);
		
		if (theDiemThi == null) {
			throw new FreetutNotFoundException("DiemThi id not found - " );
		}
		
		return theDiemThi;
	}
	
	// add mapping for POST /diemthis  - add new diemthi
	
	@PostMapping("/diemthi")
	public DiemThi addDiemThi(@RequestBody DiemThi theDiemThi) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		
		
		diemthiService.addDiemThi(theDiemThi);;
		
		return theDiemThi;
	}
	
	// add mapping for PUT /diemthis - update existing diemthi
	
	@PutMapping("/diemthi")
	public DiemThi updateDiemThi(@RequestBody DiemThi theDiemThi) {
		
		diemthiService.saveDiemThi(theDiemThi);
		
		return theDiemThi;
		
	}
	
	// add mapping for DELETE /diemthis/{diemthiId} - delete diemthi
	
	@DeleteMapping("/diemthi/{maMh}&{maSV}")
	public String deleteDiemThi(@PathVariable int maMh,@PathVariable int maSV) {
		
		DiemThi tempDiemThi = diemthiService.getDiemThi(maMh,maSV);
		
		// throw exception if null
		
		if (tempDiemThi == null) {
			throw new FreetutNotFoundException("DiemThi khong tìm thấy ");
		}
				
		diemthiService.deleteDiemThi(maMh,maSV);
		
		return "Deleted diemthi id - " +maMh+ ","+maSV;
	}
	
	@GetMapping("/diemthi/all")
	public List<Object[]> getAll(){
		
		return diemthiService.getSVMonDiem();
	}
	
	
	
}


















