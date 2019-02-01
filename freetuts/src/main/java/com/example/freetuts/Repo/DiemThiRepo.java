package com.example.freetuts.Repo;

import java.util.List;

import com.example.freetuts.model.DiemThi;
import com.example.freetuts.model.DiemThi;


public interface DiemThiRepo {
	public List<DiemThi> getDiemThi();

	public void saveDiemThi(DiemThi theDiemThi);
	
	public DiemThi getDiemThi(int mmh,int msv);

	public void deleteDiemThi(int mmh,int msv);
	public void addDiemThi(DiemThi diemThi);
	// trả về tất cả diem theo mã môn học
	public List<DiemThi> getDiemThiMh(int mmh);
	// tra ve tat ca diem theo ma sinh vien
	public List<DiemThi> getDiemThiSv(int msv);
	// tra ve sinh vien, diem, mon
	public List<Object[]> getSVMonDiem();
	
}
