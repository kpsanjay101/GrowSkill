package com.growskill.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.growskill.model.CourseSession;
import com.growskill.model.Course;
import com.growskill.model.Customer;
import com.growskill.model.Instructor;
import com.growskill.service.CourseService;
import com.growskill.service.CustomerService;
import com.growskill.service.PaymentService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private PaymentService paymentService;
    
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(),HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable String courseId) {
        return new ResponseEntity<>(courseService.getCourseById(courseId),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Course> deleteCourse(@PathVariable String courseId) {
        return new ResponseEntity<>(courseService.deleteCourse(courseId),HttpStatus.OK);
    }

//    @PostMapping("/enroll/{courseId}/customer/{customerId}")
//    public ResponseEntity<String> enrollCustomerInCourse(@PathVariable String courseId,
//            @PathVariable Integer customerId) {            
//        Course course = courseService.getCourseById(courseId);
//        Customer customer = customerService.getCustomerById(customerId);
//
//        if (course != null && customer != null) {
//            Long enrollmentFee = (long) 500; 
//
//            // Simulate payment processing
//            paymentService.processPayment(customer, course, enrollmentFee);
//
//            return ResponseEntity.ok("Enrollment successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course or customer not found");
//        }
//    }
    
//    @PatchMapping("/assignInstructor/{instructorId}/{courseId}")
//    public ResponseEntity<Instructor> assignInstructorToCourse(@PathVariable Integer instructorId, @PathVariable String courseId) {
//    	
//    	Instructor instructor = courseService.assignInstructorToCourse(courseId, instructorId);
//    	
//    	return new ResponseEntity<>(instructor, HttpStatus.OK);
//    	
//    }
}

