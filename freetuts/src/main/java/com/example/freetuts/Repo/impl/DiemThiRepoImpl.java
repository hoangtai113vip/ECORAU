package com.example.freetuts.Repo.impl;

import java.beans.Customizer;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.freetuts.Repo.DiemThiRepo;
import com.example.freetuts.model.DiemThi;
import com.example.freetuts.model.Sinhvien;



@Repository
public class DiemThiRepoImpl implements DiemThiRepo
{

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<DiemThi> getDiemThi(){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<DiemThi> theQuery = 
				currentSession.createQuery(" from DiemThi ",
											DiemThi.class);
		
		// execute query and get result list
		List<DiemThi> diemThi = theQuery.getResultList();
				
		// return the results		
		return diemThi;
	}

	@Override
	public void saveDiemThi(DiemThi theDiemThi) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the DiemThi ... finally LOL
		currentSession.update(theDiemThi);
		
	}
	public void addDiemThi(DiemThi lop) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(lop);
	}

	@Override
	public DiemThi getDiemThi(int mhId,int msvId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Query<DiemThi> theQuery = 
				currentSession.createQuery(" from DiemThi where maMh=:mhId and maSv=:msvId",DiemThi.class);
		theQuery.setParameter("mhId", mhId);
		theQuery.setParameter("msvId", msvId);
		
		DiemThi diemThi = theQuery.getSingleResult();
		
		
		return diemThi ;
	}

	@Override
	public void deleteDiemThi(int mhId,int msvId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from DiemThi where maMh=:mhId and maSv=:msvId");
		theQuery.setParameter("mhId", mhId);
		theQuery.setParameter("msvId", msvId);
		
		theQuery.executeUpdate();		
	}

	@Override
	public List<DiemThi> getDiemThiMh(int mmh) {
		Session currentSession = sessionFactory.getCurrentSession();
		// get collection diemthi with MaMh
		Query<DiemThi> theQuery = 
				currentSession.createQuery(" from DiemThi where maMh=:mhId",DiemThi.class);
		theQuery.setParameter("mhId", mmh);
	
		
		List<DiemThi> diemThi = theQuery.getResultList();
		return diemThi;
		
		
	}

	@Override
	public List<DiemThi> getDiemThiSv(int msv) {
		Session currentSession = sessionFactory.getCurrentSession();
		// get collection diemthi with MaSV
		Query<DiemThi> theQuery = 
				currentSession.createQuery(" from DiemThi where maSv=:msv",DiemThi.class);
		theQuery.setParameter("msv", msv);
	
		
		List<DiemThi> diemThi = theQuery.getResultList();
		return diemThi;
		
	}

	@Override
	public List<Object[]> getSVMonDiem() {
		// TODO Auto-generated method stub
		Session currentSession =sessionFactory.getCurrentSession();
		
		 // //get sv,diem,mon 
			List<Object[]> sVdiemMh = currentSession.createQuery(
		  "select  sv.ten,mh.tenMh,diem.diemLan1,diem.diemLan2 " + 
		 "from DiemThi diem " +"Inner join MonHoc mh on diem.maMh = mh.maMh  "+
		  " Inner join Sinhvien sv on diem.maSv = sv.maSv").list(); 
		  return sVdiemMh;
		 
	
	}

}