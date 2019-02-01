package com.example.night.service;

import java.util.List;


import com.example.night.model.Staff;

public interface StaffService {
	public List<Staff> getStaffs();

	public void saveStaff(Staff theStaff);

	public Staff getStaff(int theId);

	public void deleteStaff(int theId);
}
