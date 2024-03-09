package com.growskill.service;

import java.util.List;

import com.growskill.model.Instructor;

public interface InstructorService {
	
	public List<Instructor> getAllInstructors();
	public Instructor getInstructorById(int instructorId);
	public Instructor saveInstructor(Instructor instructor);	
	public String deleteInstructor(int instructorId);
	
	

}
