package com.example.freetuts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.freetuts.Repo.LopRepo;
import com.example.freetuts.model.Lop;
import com.example.freetuts.service.LopService;
import com.example.freetuts.service.SinhVienService;



@Service
public class LopServiceImpl implements LopService {

	// need to inject Lop dao
		@Autowired
		private LopRepo LopDAO;
		
		@Override
		@Transactional
		public List<Lop> getLops() {
			return LopDAO.getLops();
		}

		@Override
		@Transactional
		public void saveLop(Lop theLop) {

			LopDAO.saveLop(theLop);
		}

		@Override
		@Transactional
		public Lop getLop(int theId) {
			
			return LopDAO.getLop(theId);
		}

		@Override
		@Transactional
		public void deleteLop(int theId) {
			
			LopDAO.deleteLop(theId);
		}
		@Override
		@Transactional
		public void addLop(Lop sv) {
			
			LopDAO.addLop(sv);
		}

}
