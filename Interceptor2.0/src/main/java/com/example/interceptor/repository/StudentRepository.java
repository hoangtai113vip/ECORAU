package com.example.interceptor.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.interceptor.model.Student;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student,Integer> {
	

}
