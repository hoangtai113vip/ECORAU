package com.example.freetuts.Repo;

import java.util.List;

import com.example.freetuts.model.Lop;


public interface LopRepo {
	public List<Lop> getLops();

	public void saveLop(Lop theLop);

	public Lop getLop(int theId);

	public void deleteLop(int theId);
	public void addLop(Lop sv);
}
