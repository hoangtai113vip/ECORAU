package com.example.freetuts.service;

import java.util.List;

import com.example.freetuts.model.MonHoc;



public interface MonHocService {
	public List<MonHoc> getMonHocs();

	public void saveMonHoc(MonHoc theMonHoc);

	public MonHoc getMonHoc(int theId);

	public void deleteMonHoc(int theId);
	public void addMonHoc(MonHoc sv);
}
