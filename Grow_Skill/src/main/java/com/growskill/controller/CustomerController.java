package com.growskill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.growskill.model.Course;
import com.growskill.model.Customer;
import com.growskill.service.CourseService;
import com.growskill.service.CustomerService;
import com.growskill.service.PaymentService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CourseService courseService;
    @Autowired
    private  PaymentService paymentService;
    
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
    	 return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
    	return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);
    }
    
    @PostMapping("/enroll/{courseId}/customer/{customerId}/{amount}")
    public ResponseEntity<String> enrollCustomerInCourse(@PathVariable String courseId,
            @PathVariable Integer customerId, @PathVariable Long amount) {            
        Course course = courseService.getCourseById(courseId);
        Customer customer = customerService.getCustomerById(customerId);

        if (course != null && customer != null) {
            

            // Simulate payment processing
            boolean res = paymentService.processPayment(amount);
            
            if(res) {
            	customerService.buyCourses(courseId, customerId);
            	return ResponseEntity.ok("Enrollment successful");
            }
            else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment is not completed");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course or customer not found");
        }
    }

   
}

