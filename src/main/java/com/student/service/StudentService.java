package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.model.Student;

public interface StudentService {

	public Student addStudent(Student student);
	
	public String  removeStudent(int id);
	
//	public Optional<Student>  findStuById(int id);
	
	public List<Student> getAllStudent();
	
    
}

