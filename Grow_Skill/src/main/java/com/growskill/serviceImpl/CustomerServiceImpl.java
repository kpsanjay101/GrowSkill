package com.growskill.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.growskill.model.Course;
import com.growskill.model.Customer;
import com.growskill.repository.CourseRepository;
import com.growskill.repository.CustomerRepository;
import com.growskill.service.CustomerService;
import com.growskill.service.PaymentService;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
    private CustomerRepository customerRepository;

	@Autowired
    private CourseRepository courseRepository;
    
    
	@Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

	@Override
    public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

	@Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

	@Override
    public String deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
        return "Customer deleted successfuly";
    }

	@Override
	public Course buyCourses(String courseId, int customerId) {
		// TODO Auto-generated method stub courseRepository
		Optional<Course> opCourse = courseRepository.findById(courseId);
		Optional<Customer> opCustomer = customerRepository.findById(customerId);
		
		if (opCourse.isPresent() && opCustomer.isPresent()) {
            Long enrollmentFee = (long) 500; 

            // Simulate payment processing
            
            
            	Course course = opCourse.get();
            	Customer customer = opCustomer.get();
            	course.getEnrolledCustomers().add(customer);
            	courseRepository.save(course);
            	customer.getEnrolledCourses().add(course);
            	customerRepository.save(customer);
            
        }
		
		return opCourse.get();
	}

}
