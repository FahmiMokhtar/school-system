package com.fahmimokhtar.studentapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahmimokhtar.studentapp.model.Course;
import com.fahmimokhtar.studentapp.repository.CourseRepository;

@Service
public class CourseService {
	 @Autowired
	 private CourseRepository jtm;


	    public List<Course> findAll() {

	       return jtm.findAll();
	    }
	    
	    public Course saveCourse (Course course) {
	    	return jtm.save(course);
	    }
	    
	    public Course getCourse (Long id) {
	    	Optional<Course> course = jtm.findById(id);
	    	if (course.isPresent()) return course.get();
	    	
	    	else return null;
	    }
	    
	    public Course updateCourse (Course _course, Long id) {
	    	Optional<Course> course = jtm.findById(id);
	    	if (course.isPresent()) {
	    		course.get().setName(_course.getName());
	    		
	    		Course updateCourse = jtm.save(course.get());
	    		return updateCourse;
	    	} else {
	    		return null;
	    	}
	    }
	    
	    public boolean deleteCourse (Long id) {
	    	Optional<Course> course = jtm.findById(id);
	    	
	    	if (course.isPresent()) {
	    		jtm.delete(course.get());
	    		return true;
	    	} else {
	    		return false;
	    	}
	    }
	    
}
