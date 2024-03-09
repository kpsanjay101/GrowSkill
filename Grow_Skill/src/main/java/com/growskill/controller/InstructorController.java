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

import com.growskill.model.Instructor;
import com.growskill.service.InstructorService;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return new ResponseEntity<List<Instructor>>(instructorService.getAllInstructors(), HttpStatus.OK) ;
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<Instructor>  getInstructorById(@PathVariable int instructorId) {
        return new ResponseEntity<>(instructorService.getInstructorById(instructorId), HttpStatus.OK); 
    }

    @PostMapping
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor) {
    	return new ResponseEntity<>(instructorService.saveInstructor(instructor),HttpStatus.CREATED);
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity<String> deleteInstructor(@PathVariable int instructorId) {
        instructorService.deleteInstructor(instructorId);
        return new ResponseEntity<String>(instructorService.deleteInstructor(instructorId), HttpStatus.OK);
    }

   
}

