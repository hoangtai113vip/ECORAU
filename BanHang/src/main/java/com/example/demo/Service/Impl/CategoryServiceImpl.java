package com.example.demo.Service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.CategoryService;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	@Override
	@Transactional
	public List<Category> getAll() {
	
		return categoryRepo.getAll();
	}

	@Override
	@Transactional
	public void update(Category cate) {
		// TODO Auto-generated method stub
		categoryRepo.update(cate);
		
	}

	@Override
	@Transactional
	public Category getOne(int id) {
		// TODO Auto-generated method stub
		return categoryRepo.getOne(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryRepo.delete(id);
		
	}

	@Override
	@Transactional
	public void add(Category cate) {
		// TODO Auto-generated method stub
		categoryRepo.add(cate);
		
	}

}
