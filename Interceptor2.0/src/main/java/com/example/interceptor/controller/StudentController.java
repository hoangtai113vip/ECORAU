package com.example.interceptor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interceptor.model.Student;
import com.example.interceptor.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	@GetMapping("")
	public List<Student> getAll(){
		List<Student> students = (List<Student>) studentRepository.findAll();
		return students;
	}
	@PostMapping("")
	public Student save(@RequestBody Student student)
	{
		studentRepository.save(student);
		return student;
	}

}
