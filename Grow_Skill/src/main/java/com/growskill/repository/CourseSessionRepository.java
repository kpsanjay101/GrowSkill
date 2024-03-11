package com.growskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.growskill.model.CourseSession;
import com.growskill.model.Course;

public interface CourseSessionRepository extends JpaRepository<CourseSession, Integer>{

}
