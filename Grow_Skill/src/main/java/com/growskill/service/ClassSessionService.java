package com.growskill.service;

import java.util.List;

import com.growskill.model.ClassSession;

public interface ClassSessionService {
	
	 public List<ClassSession> getAllSessions();
	 public ClassSession getSessionById(int sessionId);
	 public ClassSession saveSession(ClassSession session);
	 public String deleteSession(int sessionId);
	 
	 

}
