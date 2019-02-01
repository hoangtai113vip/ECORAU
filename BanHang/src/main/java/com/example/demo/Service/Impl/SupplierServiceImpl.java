package com.example.demo.Service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.SupplierService;
import com.example.demo.model.Supplier;
import com.example.demo.repository.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierRepo suppliergoryRepo;
	@Override
	@Transactional
	public List<Supplier> getAll() {
	
		return suppliergoryRepo.getAll();
	}

	@Override
	@Transactional
	public void update(Supplier supplier) {
		// TODO Auto-generated method stub
		suppliergoryRepo.update(supplier);
		
	}

	@Override
	@Transactional
	public Supplier getOne(int id) {
		// TODO Auto-generated method stub
		return suppliergoryRepo.getOne(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		suppliergoryRepo.delete(id);
		
	}

	@Override
	@Transactional
	public void add(Supplier supplier) {
		// TODO Auto-generated method stub
		suppliergoryRepo.add(supplier);
		
	}

}
