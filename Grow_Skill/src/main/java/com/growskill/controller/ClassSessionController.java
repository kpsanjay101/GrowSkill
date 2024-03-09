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

import com.growskill.model.ClassSession;
import com.growskill.model.Instructor;
import com.growskill.service.ClassSessionService;

@RestController
@RequestMapping("/sessions")
public class ClassSessionController {
    @Autowired
    private ClassSessionService sessionService;
    
    @GetMapping
    public ResponseEntity<List<ClassSession>> getAllSessions() {
        return new ResponseEntity<List<ClassSession>>(sessionService.getAllSessions(), HttpStatus.OK) ;
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<ClassSession> getSessionById(@PathVariable int sessionId) {
        return new ResponseEntity<>(sessionService.getSessionById(sessionId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClassSession> saveSession(@RequestBody ClassSession session) {
        return new ResponseEntity<>(sessionService.saveSession(session),HttpStatus.CREATED);
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<String> deleteSession(@PathVariable int sessionId) {
        return new ResponseEntity<>(sessionService.deleteSession(sessionId), HttpStatus.OK);
    }

   
}

