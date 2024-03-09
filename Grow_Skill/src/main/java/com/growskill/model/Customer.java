package com.growskill.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
      name = "customer_course",
      joinColumns = @JoinColumn(name = "customer_id"),
      inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> enrolledCourses;
}
