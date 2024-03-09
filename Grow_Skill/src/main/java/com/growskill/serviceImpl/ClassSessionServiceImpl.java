package com.growskill.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.model.ClassSession;
import com.growskill.repository.ClassSessionRepository;
import com.growskill.service.ClassSessionService;

@Service
public class ClassSessionServiceImpl implements ClassSessionService{
	
	@Autowired
    private ClassSessionRepository sessionRepository;

	@Override
    public List<ClassSession> getAllSessions() {
        return sessionRepository.findAll();
    }
	
	@Override
    public ClassSession getSessionById(int sessionId) {
        return sessionRepository.findById(sessionId).orElse(null);
    }
	
	@Override
    public ClassSession saveSession(ClassSession session) {
        return sessionRepository.save(session);
    }
	
	@Override
    public String deleteSession(int sessionId) {
        sessionRepository.deleteById(sessionId);
        return "Session deleted successfully";
    }


}
