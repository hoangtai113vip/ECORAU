package com.example.freetuts.service;

import java.util.List;

import com.example.freetuts.model.Lop;



public interface LopService {
	public List<Lop> getLops();

	public void saveLop(Lop theLop);

	public Lop getLop(int theId);

	public void deleteLop(int theId);
	public void addLop(Lop sv);
}
