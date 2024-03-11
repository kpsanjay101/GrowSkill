package com.growskill.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.growskill.exceptionHandler.CourseNotFoundException;
import com.growskill.exceptionHandler.CustomerNotFoundException;
import com.growskill.exceptionHandler.PaymentException;
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
    
	@Autowired
    private PaymentService paymentService;
	@Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

	@Override
    public Customer getCustomerById(int customerId) {
		Optional<Customer> opCustomer = customerRepository.findById(customerId);
		if(opCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer doesn't exist with this customerId: "+customerId);
		}
        return opCustomer.get();
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
	public Course buyCourses(String courseId, int customerId, long amount) {
		// TODO Auto-generated method stub courseRepository
		Optional<Course> opCourse = courseRepository.findById(courseId);
		Optional<Customer> opCustomer = customerRepository.findById(customerId);
		
		if(opCourse.isEmpty()) {
			throw new CourseNotFoundException("Course doesn't exist with this courseId : "+courseId);
		}
		if(opCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer doesn't exist with this customerId: "+customerId);
		}
		
		boolean res = paymentService.processPayment(amount,opCourse.get());
		
		if(res) {
			Course course = opCourse.get();
			Long enrollmentFee = opCourse.get().getCourseAmount(); 
	    	Customer customer = opCustomer.get();
	    	course.getEnrolledCustomers().add(customer);
	    	courseRepository.save(course);
	    	customer.getEnrolledCourses().add(course);
	    	customerRepository.save(customer);	
		}else {
			throw new PaymentException("Pay didn't complete");
		}
		
		return opCourse.get();
	}

}
