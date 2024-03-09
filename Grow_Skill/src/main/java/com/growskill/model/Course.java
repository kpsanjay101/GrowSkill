package com.growskill.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    private String courseName;
    
    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClassSession> session;
    
   
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledCourses")
    private List<Customer> enrolledCustomers;

}
