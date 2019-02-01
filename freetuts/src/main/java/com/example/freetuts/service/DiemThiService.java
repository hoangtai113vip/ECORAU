package com.example.freetuts.service;

import java.util.List;

import com.example.freetuts.model.DiemThi;
import com.example.freetuts.model.DiemThi;


public interface DiemThiService {
	public List<DiemThi> getDiemThi();

	public void saveDiemThi(DiemThi theDiemThi);

	public DiemThi getDiemThi(int maMh,int maSV);

	public void deleteDiemThi(int mmh,int msv);
	public void addDiemThi(DiemThi diemThi);
	// trả về tất cả diem theo mã môn học
		public List<DiemThi> getDiemThiMh(int mmh);
		// tra ve tat ca diem theo ma sinh vien
		public List<DiemThi> getDiemThiSv(int msv);
	// tra ve ten sv, ten mon, diem	
		public List<Object[]> getSVMonDiem();
}
