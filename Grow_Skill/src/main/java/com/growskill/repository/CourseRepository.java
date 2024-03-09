package com.growskill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.growskill.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	List<Course> findByInstructorId(int instructorId);

}
