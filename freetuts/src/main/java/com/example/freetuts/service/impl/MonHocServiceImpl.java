package com.example.freetuts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.freetuts.Repo.MonHocRepo;
import com.example.freetuts.model.MonHoc;
import com.example.freetuts.service.MonHocService;
import com.example.freetuts.service.MonHocService;
import com.example.freetuts.service.SinhVienService;



@Service
public class MonHocServiceImpl implements MonHocService {

	// need to inject MonHoc dao
		@Autowired
		private MonHocRepo MonHocDAO;
		
		@Override
		@Transactional
		public List<MonHoc> getMonHocs() {
			return MonHocDAO.getMonHocs();
		}

		@Override
		@Transactional
		public void saveMonHoc(MonHoc theMonHoc) {

			MonHocDAO.saveMonHoc(theMonHoc);
		}

		@Override
		@Transactional
		public MonHoc getMonHoc(int theId) {
			
			return MonHocDAO.getMonHoc(theId);
		}

		@Override
		@Transactional
		public void deleteMonHoc(int theId) {
			
			MonHocDAO.deleteMonHoc(theId);
		}
		@Override
		@Transactional
		public void addMonHoc(MonHoc sv) {
			
			MonHocDAO.addMonHoc(sv);
		}

}
