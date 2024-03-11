package com.growskill.service;

import java.util.List;

import com.growskill.model.Course;
import com.growskill.model.Instructor;

public interface CourseService {
	
	public List<Course> getAllCourses();
	public Course getCourseById(String courseId);
	public Course saveCourse(Course course);
	public Course deleteCourse(String courseId);
	

}
