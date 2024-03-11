package com.growskill.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return courseRepository.save(course);
		
	}

	@Override
	public String deleteCourse(String courseId) {
		courseRepository.deleteById(courseId);
		return "course deleted successfuly";
		
	}

//	@Override
//	public Instructor assignInstructorToCourse(String courseId, int instructorId) {
//		// TODO Auto-generated method stub
//		Optional<Course> opCourse = courseRepository.findById(courseId);
//		Optional<Instructor> opInstructor = instructorRepository.findById(instructorId);
//		if(opCourse.isPresent() && opInstructor.isPresent()) {
//			Course findedCourse = opCourse.get();
//			findedCourse.setInstructor(opInstructor.get());
//			courseRepository.save(findedCourse);
//		}
//		return opInstructor.get();
//	}
	


}
