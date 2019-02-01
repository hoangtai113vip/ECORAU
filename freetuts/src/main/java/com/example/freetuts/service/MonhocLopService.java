package com.example.freetuts.service;

import java.util.List;

import javax.persistence.Tuple;

import com.example.freetuts.model.Lop;
import com.example.freetuts.model.MonhocLop;



public interface MonhocLopService {
	public List<MonhocLop> getMonhocLop();

	public void saveMonhocLop(MonhocLop theMonhocLop);

	public MonhocLop getMonhocLop(int maMh,int maLop);

	public void deleteMonhocLop(int maMh,int maLop);
	public void addMonhocLop(MonhocLop mhl);
	public List<Object[]> getJoinTable();
}
