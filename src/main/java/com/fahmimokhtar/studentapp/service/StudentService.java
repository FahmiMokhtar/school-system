package com.fahmimokhtar.studentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahmimokhtar.studentapp.model.Course;
import com.fahmimokhtar.studentapp.model.Student;
import com.fahmimokhtar.studentapp.repository.CourseRepository;
import com.fahmimokhtar.studentapp.repository.StudentRepository;

@Service
public class StudentService {
	
	 @Autowired
	 private StudentRepository jtm;
	 
	 @Autowired
	 private CourseRepository ctm;

	    public List<Student> findAll() {

	       return jtm.findAll();
	    }
	    
	    public Student saveStudent (Student _student) {
	    	Optional<Student> student = ctm.findById(_student.getCourseid()).map(course -> {
	    		_student.setCourse(course);
	    		return jtm.save(_student);
	    	});
	    	
	    	if (student.isPresent()) return student.get();
	    	else return null;
	    }
	    
	    public Student getStudent (Long id) {
	    	Optional<Student> student = jtm.findById(id);
	    	if (student.isPresent()) return student.get();
	    	
	    	else return null;
	    }
	    
	    public Student updateStudent (Student _student, Long id) {
	    	Optional<Student> student = jtm.findById(id);
	    	if (student.isPresent()) {
	    		student.get().setName(_student.getName());
	    		Optional<Course> newCource = ctm.findById(_student.getCourseid());
	    		student.get().setCourse(newCource.get());
	    		
	    		Student updateStudent = jtm.save(student.get());
	    		return updateStudent;
	    	} else {
	    		return null;
	    	}
	    }
	    
	    public boolean deleteStudent (Long id) {
	    	Optional<Student> student = jtm.findById(id);
	    	
	    	if (student.isPresent()) {
	    		jtm.delete(student.get());
	    		return true;
	    	} else {
	    		return false;
	    	}
	    }
}
