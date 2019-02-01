package com.example.freetuts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.freetuts.Repo.DiemThiRepo;
import com.example.freetuts.model.DiemThi;
import com.example.freetuts.service.DiemThiService;




@Service
public class DiemThiServiceImpl implements DiemThiService {

	// need to inject DiemThi dao
		@Autowired
		private DiemThiRepo DiemThiDAO;
		
		@Override
		@Transactional
		public List<DiemThi> getDiemThi() {
			return DiemThiDAO.getDiemThi();
		}

		@Override
		@Transactional
		public void saveDiemThi(DiemThi theDiemThi) {

			DiemThiDAO.saveDiemThi(theDiemThi);
		}

		@Override
		@Transactional
		public DiemThi getDiemThi(int maMh,int maSV) {
			
			return DiemThiDAO.getDiemThi(maMh,maSV);
		}

		@Override
		@Transactional
		public void deleteDiemThi(int maMh,int maSV) {
			
			DiemThiDAO.deleteDiemThi(maMh, maSV);
		}
		@Override
		@Transactional
		public void addDiemThi(DiemThi diemThi) {
			
			DiemThiDAO.addDiemThi(diemThi);
		}

		@Override
		@Transactional
		public List<DiemThi> getDiemThiMh(int mmh) {
			return DiemThiDAO.getDiemThiMh(mmh);
		}

		@Override
		@Transactional
		public List<DiemThi> getDiemThiSv(int msv) {
			
			return DiemThiDAO.getDiemThiSv(msv);
		}

		@Override
		@Transactional
		public List<Object[]> getSVMonDiem() {
			return DiemThiDAO.getSVMonDiem();
		}

}
