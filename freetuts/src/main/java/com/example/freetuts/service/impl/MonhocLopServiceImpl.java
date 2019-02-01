package com.example.freetuts.service.impl;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.freetuts.Repo.LopRepo;
import com.example.freetuts.Repo.MonhocLopRepo;
import com.example.freetuts.model.Lop;
import com.example.freetuts.model.MonhocLop;
import com.example.freetuts.service.LopService;
import com.example.freetuts.service.MonhocLopService;
import com.example.freetuts.service.SinhVienService;



@Service
public class MonhocLopServiceImpl implements MonhocLopService {

	// need to inject Lop dao
		@Autowired
		private MonhocLopRepo monhocLopDAO;
		
		@Override
		@Transactional
		public List<MonhocLop> getMonhocLop() {
			return monhocLopDAO.getMonhocLop();
		}

		@Override
		@Transactional
		public void saveMonhocLop(MonhocLop theLop) {

			monhocLopDAO.saveMonhocLop(theLop);
		}

		@Override
		@Transactional
		public MonhocLop getMonhocLop(int maMh,int maLop) {
			
			return monhocLopDAO.getMonhocLop(maMh, maLop);
		}

		@Override
		@Transactional
		public void deleteMonhocLop(int maMh,int maLop) {
			
			monhocLopDAO.deleteMonhocLop(maMh,maLop);
		}
		@Override
		@Transactional
		public void addMonhocLop(MonhocLop mhl) {
			
			monhocLopDAO.addMonhocLop(mhl);
		}
		@Override
		@Transactional
		public List<Object[]> getJoinTable(){
			 return monhocLopDAO.getJoinTable();
		}

}
