package com.example.freetuts.service;

import java.util.List;

import com.example.freetuts.model.Sinhvien;



public interface SinhVienService {
	public List<Sinhvien> getSinhviens(int start);

	public void saveSinhvien(Sinhvien theSinhvien);

	public Sinhvien getSinhvien(int theId);

	public void deleteSinhvien(int theId);
	public void addSinhvien(Sinhvien sv);
}
