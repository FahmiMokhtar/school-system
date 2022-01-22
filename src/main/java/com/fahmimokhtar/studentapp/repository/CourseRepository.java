package com.fahmimokhtar.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahmimokhtar.studentapp.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
