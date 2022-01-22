package com.fahmimokhtar.studentapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahmimokhtar.studentapp.exception.ResourceNotFoundException;
import com.fahmimokhtar.studentapp.model.Student;
import com.fahmimokhtar.studentapp.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    @Autowired
    private StudentService studentService;
    
    @GetMapping
    public Iterable findAll() {
    	return studentService.findAll();
    }
    
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
    
    @GetMapping("/{id}")
	public Student getStudentById(@PathVariable(value = "id") Long studentId) {
    	
    	Student student = studentService.getStudent(studentId);
		if (student != null) return student;
		else throw(new ResourceNotFoundException("Student", "id", studentId));
	}
    
    @PutMapping("/{id}")
	public Student updateStudent(@PathVariable(value = "id") Long studentId, @RequestBody Student studentDetails) {
    	Student student = studentService.updateStudent(studentDetails, studentId);
    	if (student != null) return student;
    	else throw(new ResourceNotFoundException("Student", "id", studentId));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long studentId) {
    	if (studentService.deleteStudent(studentId)) return ResponseEntity.ok().build();
    	else throw(new ResourceNotFoundException("Student", "id", studentId));
    }
    
}
