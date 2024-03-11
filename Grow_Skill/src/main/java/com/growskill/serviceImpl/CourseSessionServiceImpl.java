package com.growskill.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.model.CourseSession;
import com.growskill.model.Instructor;
import com.growskill.exceptionHandler.CourseNotFoundException;
import com.growskill.exceptionHandler.InstructorNotFoundException;
import com.growskill.model.Course;
import com.growskill.repository.CourseSessionRepository;
import com.growskill.repository.InstructorRepository;
import com.growskill.repository.CourseRepository;
import com.growskill.service.CourseSessionService;

@Service
public class CourseSessionServiceImpl implements CourseSessionService{
	
	@Autowired
    private CourseSessionRepository sessionRepository;
	
	@Autowired
    private CourseRepository courseRepository;
	
	@Autowired
    private InstructorRepository instructorRepository;
	

	@Override
    public List<CourseSession> getAllSessions() {
        return sessionRepository.findAll();
    }
	
	@Override
    public CourseSession getSessionById(int sessionId) {
        return sessionRepository.findById(sessionId).orElse(null);
    }
	
	@Override
    public CourseSession saveSession(CourseSession session, String courseId, int instructorId) {
		
		Optional<Course> optionalCourse = courseRepository.findById(courseId);
		Optional<Instructor> optionalInstructor =  instructorRepository.findById(instructorId);
		CourseSession saveSession = null; 
		if(optionalCourse.isEmpty()) {
			throw new CourseNotFoundException("Course doesn't exist with this courseId : "+courseId);
		}
		
		if(optionalInstructor.isEmpty()) {
			throw new InstructorNotFoundException("Instructor doesn't exist with this instructorId : "+instructorId);
		}
		
		session.setCourse(optionalCourse.get());
		session.setInstructor(optionalInstructor.get());
		courseRepository.save(optionalCourse.get());
		saveSession = sessionRepository.save(session);
		optionalCourse.get().getSession().add(saveSession);
        return saveSession;
    }
	
	@Override
    public String deleteSession(int sessionId) {
        sessionRepository.deleteById(sessionId);
        return "Session deleted successfully";
    }

	@Override
	public List<CourseSession> getAllSessionByCourseId(String courseId) {
		Optional<Course> optionalCourse = courseRepository.findById(courseId);

	    if (optionalCourse.isPresent()) {
	        Course course = optionalCourse.get();
	        return course.getSession();
	    } else {
	    	throw new CourseNotFoundException("Course doesn't exist with this courseId : "+courseId);
	    }
	}


}
