package com.growskill.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClassSession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  
    private String date;
    private String time;
    private String topic;
    private String zoomLink;
    
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
