package com.example.freetuts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.freetuts.Repo.SinhVienRepo;
import com.example.freetuts.model.Sinhvien;
import com.example.freetuts.service.SinhVienService;



@Service
public class SinhVienServiceImpl implements SinhVienService {

	// need to inject Sinhvien dao
		@Autowired
		private SinhVienRepo SinhvienDAO;
		
		@Override
		@Transactional
		public List<Sinhvien> getSinhviens(int start) {
			return SinhvienDAO.getSinhviens(start);
		}

		@Override
		@Transactional
		public void saveSinhvien(Sinhvien theSinhvien) {

			SinhvienDAO.saveSinhvien(theSinhvien);
		}

		@Override
		@Transactional
		public Sinhvien getSinhvien(int theId) {
			
			return SinhvienDAO.getSinhvien(theId);
		}

		@Override
		@Transactional
		public void deleteSinhvien(int theId) {
			
			SinhvienDAO.deleteSinhvien(theId);
		}
		@Override
		@Transactional
		public void addSinhvien(Sinhvien sv) {
			
			SinhvienDAO.addSinhvien(sv);
		}

}
