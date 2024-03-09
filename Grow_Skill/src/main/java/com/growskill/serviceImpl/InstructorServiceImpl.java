package com.growskill.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.model.Instructor;
import com.growskill.repository.InstructorRepository;
import com.growskill.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
    private InstructorRepository instructorRepository;

	@Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

	@Override
    public Instructor getInstructorById(int instructorId) {
        return instructorRepository.findById(instructorId).orElse(null);
    }

	@Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }
	
	@Override
    public String deleteInstructor(int instructorId) {
        instructorRepository.deleteById(instructorId);
        return "Instructor deleted successfully";
    }

}
