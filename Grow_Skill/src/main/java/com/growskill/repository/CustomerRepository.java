package com.growskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.growskill.model.CourseSession;
import com.growskill.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
