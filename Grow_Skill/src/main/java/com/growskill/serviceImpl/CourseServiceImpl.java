package com.growskill.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.exceptionHandler.CourseAllReadyExistException;
import com.growskill.exceptionHandler.CourseNotFoundException;
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
	public Course getCourseById(String courseId) {
		Optional<Course> opCourse = courseRepository.findById(courseId);
		if(opCourse.isEmpty()) {
			throw new CourseNotFoundException("Course doesn't exist with this courseId : "+courseId);
		}
		
		return opCourse.get();
	}


	@Override
	public Course saveCourse(Course course) {
		Optional<Course> opCourse = courseRepository.findById(course.getCourseId());
		if(opCourse.isPresent()) {
			throw new CourseAllReadyExistException("Course all ready exist with this courseId : "+course.getCourseId());
		}
		
		return courseRepository.save(course);
		
	}

	@Override
	public Course deleteCourse(String courseId) {
		
		Optional<Course> opCourse = courseRepository.findById(courseId);
		if(opCourse.isEmpty()) {
			throw new CourseNotFoundException("Course doesn't exist with this courseId : "+courseId);
		}
		
		courseRepository.deleteById(courseId);
		return opCourse.get();
		
	}

	
}
