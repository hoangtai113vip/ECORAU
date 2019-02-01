package com.example.demo.Service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	@Override
	@Transactional
	public List<Product> getAll() {
	
		return productRepo.getAll();
	}

	@Override
	@Transactional
	public void update(Product pro) {
		// TODO Auto-generated method stub
		productRepo.update(pro);
		
	}

	@Override
	@Transactional
	public Product getOne(int id) {
		// TODO Auto-generated method stub
		return productRepo.getOne(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		productRepo.delete(id);
		
	}

	@Override
	@Transactional
	public void add(Product pro) {
		// TODO Auto-generated method stub
		productRepo.add(pro);
		
	}

}
