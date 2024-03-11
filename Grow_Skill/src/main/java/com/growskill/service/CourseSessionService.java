package com.growskill.service;

import java.util.List;

import com.growskill.model.CourseSession;
import com.growskill.model.Instructor;

public interface CourseSessionService {
	
	 public List<CourseSession> getAllSessions();
	 public CourseSession getSessionById(int sessionId);
	 public CourseSession saveSession(CourseSession session, String courseId, int instructorId);
	 public String deleteSession(int sessionId);
	 public List<CourseSession> getAllSessionByCourseId(String courseId);
//	 public Instructor assignInstructorToCourse(String courseId, int instructorId);
	 

}
