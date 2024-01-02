package com.student.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

	Optional<Student> findStuById(int id);

	Optional<Student> getStuById(int id);



}
