package com.example.freetuts.Repo;

import java.util.List;

import javax.persistence.Tuple;

import com.example.freetuts.model.Lop;
import com.example.freetuts.model.MonhocLop;


public interface MonhocLopRepo {
	public List<MonhocLop> getMonhocLop();

	public void saveMonhocLop(MonhocLop theMonhocLop);

	public MonhocLop getMonhocLop(int maMh,int maLop);

	public void deleteMonhocLop(int maMh,int maLop);
	public void addMonhocLop(MonhocLop sv);
	public List<Object[]> getJoinTable();
}
