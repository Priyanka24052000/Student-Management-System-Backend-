package com.student.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Repository.StudentRepo;
import com.student.exception.ResourceNotFoundException;
import com.student.model.Student;
import com.student.service.StudentServiceImpl;

import jakarta.annotation.security.PermitAll;



@RestController
@RequestMapping("/stu")
@CrossOrigin(origins="*")
public class StudentController {

    @Autowired
	private StudentServiceImpl stuService;
    
    @Autowired
	private StudentRepo studentRepo;
	
   //create new student
    @PostMapping("/addstu")
    public Student createStudent(@RequestBody Student student) {
		return studentRepo.save(student);
		
	}
    //delete student
    @DeleteMapping("/removestu/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable int id){
		stuService.removeStudent(id);
		HashMap<String, String> response=new HashMap<>();
		response.put("message", "removed Successfully");
    	return new ResponseEntity<>(response,HttpStatus.ACCEPTED) ;
    	
    }
    //get student by id
    @GetMapping("/findstu/{id}")
    public ResponseEntity<Student>getStuById(@PathVariable int id){
		
    	Student student = studentRepo.getStuById(id)
    			.orElseThrow(()-> new ResourceNotFoundException("Student not exist with id:" + id));
    	return  ResponseEntity.ok(student) ;
    	
    }
    
    //get all student
	@GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> stu = stuService.getAllStudent();    	
    	return new ResponseEntity<List<Student>>(stu,HttpStatus.ACCEPTED);
    	
    }
	//update student by id
    @PutMapping("/updatestu/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id,@RequestBody Student student)
    {
    	Optional<Student> stu = studentRepo.findById(id);
    	if(stu.isPresent()) {
    		if(student.getFirst_name()!=null) {
    			stu.get().setFirst_name(student.getFirst_name());
    			
    		}
    		if(student.getLast_name()!=null) {
    			stu.get().setLast_name(student.getLast_name());
    			
    		}
    		if(student.getEmail()!=null) {
    			stu.get().setEmail(student.getEmail());
    			
    		}
    		if(student.getFirst_name()!=null) {
    			stu.get().setFirst_name(student.getFirst_name());
    			
    		}
    		if(student.getPhone()!=0) {
    			stu.get().setPhone(student.getPhone());
    			
    		}
    		if(student.getDepartment()!=null) {
    			stu.get().setDepartment(student.getDepartment());
    			
    		}
    		this.stuService.addStudent(stu.get());
    	}
    	HashMap<String, String> response=new HashMap<>();
		response.put("message", "Updated Successfully");
    	return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    	
    }
    
}

