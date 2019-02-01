package com.example.night.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.night.dao.StaffDAO;
import com.example.night.model.Staff;


@Service
public class StaffServiceImpl implements StaffService {

	// need to inject staff dao
		@Autowired
		private StaffDAO staffDAO;
		
		@Override
		@Transactional
		public List<Staff> getStaffs() {
			return staffDAO.getStaffs();
		}

		@Override
		@Transactional
		public void saveStaff(Staff theStaff) {

			staffDAO.saveStaff(theStaff);
		}

		@Override
		@Transactional
		public Staff getStaff(int theId) {
			
			return staffDAO.getStaff(theId);
		}

		@Override
		@Transactional
		public void deleteStaff(int theId) {
			
			staffDAO.deleteStaff(theId);
		}

}
