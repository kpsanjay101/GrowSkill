package com.growskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.growskill.model.ClassSession;
import com.growskill.model.Course;

public interface ClassSessionRepository extends JpaRepository<ClassSession, Integer>{

}
