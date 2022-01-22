package com.fahmimokhtar.studentapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="courseid", nullable=true)
	private Course course;
    
    @Transient
    private Long courseid;

	public Long getCourseid() {
		return courseid;
	}

	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long studentid) {
		this.id = studentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
    
    
}
