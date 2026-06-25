package com.studentmgmt.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmgmt.entity.Student;
import com.studentmgmt.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController {
	private final StudentService service;


	StudentController(StudentService service) {
		this.service = service;
	}
	

	
	@GetMapping
	public List<Student> getAllStudents() {
	    return service.getAllStudents();
	}
	
	
	
	
	@PostMapping 
	public Student saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
		
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(
	        @PathVariable int id) {

	    return service.getStudentById(id);
	}
	
	
	@PutMapping("/{id}")
	public Student updateStudent(
	        @PathVariable Integer id,
	        @RequestBody Student student) {

	    return service.updateStudent(id, student);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(
	        @PathVariable Integer id) {

	    service.deleteStudent(id);

	    return "Student Deleted Successfully";
	}
}
