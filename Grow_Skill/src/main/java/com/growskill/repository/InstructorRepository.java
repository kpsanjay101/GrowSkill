package com.growskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.growskill.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

}
