package com.fahmimokhtar.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahmimokhtar.studentapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
