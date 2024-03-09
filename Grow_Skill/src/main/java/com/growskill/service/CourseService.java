package com.growskill.service;

import java.util.List;

import com.growskill.model.Course;

public interface CourseService {
	
	public List<Course> getAllCourses();
	public Course getCourseById(int courseId);
	public List<Course> getCoursesByInstructor(int instructorId);
	public Course saveCourse(Course course);
	public String deleteCourse(int courseId);

}
