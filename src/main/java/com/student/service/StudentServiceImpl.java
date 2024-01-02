package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Repository.StudentRepo;
import com.student.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	//refernce of repository class
	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Student addStudent(Student student) {
        Student stu= studentRepo.save(student);
		return stu;
	}

	@Override
	public String removeStudent(int id) {

		studentRepo.deleteById(id);
		return "delete data successful";
	}

//	@Override
//	public Optional<Student> findStuById(int id) {
//
//        Optional<Student> stu=studentRepo.findById(id);
//        
//        if(stu.isPresent()) {
//        	return stu;
//        }else {
//		return null;
//	}

	@Override
	public List<Student> getAllStudent() {

        List<Student> stuList= studentRepo.findAll();
        return stuList;
	}

//	@Override
//	public String updateStudent(int id) {
//
//       Optional<Student> stu = studentRepo.findById(id);
//       if(stu.isPresent()) {
//    	   Student stds=new Student();
//    	   studentRepo.save(stds);
//       return "updated successfully";
//	}else {
//	return "Student not found";
//}
	}
	
