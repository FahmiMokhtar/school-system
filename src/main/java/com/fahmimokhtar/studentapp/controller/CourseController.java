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
import com.fahmimokhtar.studentapp.model.Course;
import com.fahmimokhtar.studentapp.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @GetMapping
    public Iterable findAll() {
    	return courseService.findAll();
    }
    
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}
    
    @GetMapping("/{id}")
	public Course getCourseById(@PathVariable(value = "id") Long courseId) {
    	
    	Course course = courseService.getCourse(courseId);
		if (course != null) return course;
		else throw(new ResourceNotFoundException("Course", "id", courseId));
	}
    
    @PutMapping("/{id}")
	public Course updateCourse(@PathVariable(value = "id") Long courseId, @RequestBody Course courseDetails) {
    	Course course = courseService.updateCourse(courseDetails, courseId);
    	if (course != null) return course;
    	else throw(new ResourceNotFoundException("Course", "id", courseId));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable(value = "id") Long courseId) {
    	if (courseService.deleteCourse(courseId)) return ResponseEntity.ok().build();
    	else throw(new ResourceNotFoundException("Student", "id", courseId));
    }
}
