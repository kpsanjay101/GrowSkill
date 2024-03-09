package com.growskill.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.model.Course;
import com.growskill.repository.CourseRepository;
import com.growskill.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
    private CourseRepository courseRepository;

	@Override
	public List<Course> getAllCourses() {
		 return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(int courseId) {
		return courseRepository.findById(courseId).orElse(null);
	}

	@Override
	public List<Course> getCoursesByInstructor(int instructorId) {
		return courseRepository.findByInstructorId(instructorId);
	}

	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
		
	}

	@Override
	public String deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);
		return "course deleted successfuly";
		
	}
	


}
