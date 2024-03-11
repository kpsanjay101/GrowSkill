package com.growskill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.growskill.model.CourseSession;
import com.growskill.model.Instructor;
import com.growskill.service.CourseSessionService;

@RestController
@RequestMapping("/sessions")
public class CourseSessionController {
    @Autowired
    private CourseSessionService sessionService;
    
    @GetMapping
    public ResponseEntity<List<CourseSession>> getAllSessions() {
        return new ResponseEntity<List<CourseSession>>(sessionService.getAllSessions(), HttpStatus.OK) ;
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<CourseSession> getSessionById(@PathVariable Integer sessionId) {
        return new ResponseEntity<>(sessionService.getSessionById(sessionId),HttpStatus.OK);
    }

    @PostMapping("/{courseId}/{instructorId}")
    public ResponseEntity<CourseSession> saveSession(@RequestBody CourseSession session, @PathVariable String courseId, 
    		@PathVariable Integer instructorId) {
        return new ResponseEntity<>(sessionService.saveSession(session,courseId,instructorId),HttpStatus.CREATED);
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<String> deleteSession(@PathVariable Integer sessionId) {
        return new ResponseEntity<>(sessionService.deleteSession(sessionId), HttpStatus.OK);
    }
    
    @GetMapping("/session/{courseId}")
    public ResponseEntity<List<CourseSession>> getAllSessionsByCourseId(@PathVariable String courseId) {
        return new ResponseEntity<List<CourseSession>>(sessionService.getAllSessionByCourseId(courseId), HttpStatus.OK) ;
    }

   
}

