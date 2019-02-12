package com.example.database.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.database.entity.Product;
import com.example.database.entity.Supplier;

@Repository
@Transactional
public class SupplierRepository {
	@Autowired
	EntityManager em;
	
	public List<Supplier> getAll(){
			
		TypedQuery<Supplier> query = em.createQuery("From Supplier",Supplier.class);
		List<Supplier> sup = query.getResultList();
		return sup;
		
	}
	public Supplier getOne(int id) {
		return em.find(Supplier.class,id);
	}
	public void add(Supplier supplier)
	{
		em.merge(supplier);
	
	}
	public void  update(Supplier supplier) {
		em.persist(supplier);
	}
	public void delete(Supplier supplier) {
		em.remove(supplier);
	
		
	}
	
	
}
