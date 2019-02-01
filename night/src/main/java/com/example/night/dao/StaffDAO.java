package com.example.night.dao;

import java.util.List;

import com.example.night.model.Staff;

public interface StaffDAO {
	public List<Staff> getStaffs();

	public void saveStaff(Staff theStaff);

	public Staff getStaff(int theId);

	public void deleteStaff(int theId);
}
