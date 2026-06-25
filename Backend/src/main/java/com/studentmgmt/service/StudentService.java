package com.studentmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentmgmt.entity.Student;
import com.studentmgmt.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository repository;
	

	StudentService(StudentRepository repository) {
		this.repository = repository;
	}
	
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	
	public List<Student> getAllStudents() {
	    return repository.findAll();
	}
	
	public Student getStudentById(int id) {
	    return repository.findById(id)
	            .orElseThrow();
	}
	
	public Student updateStudent(int id, Student student) {

	    Student existingStudent =
	            repository.findById(id)
	            .orElseThrow();

	    existingStudent.setName(student.getName());
	    existingStudent.setEmail(student.getEmail());
	    existingStudent.setAge(student.getAge());

	    return repository.save(existingStudent);
	}
	
	public void deleteStudent(int id) {
	    repository.deleteById(id);
	}

}


