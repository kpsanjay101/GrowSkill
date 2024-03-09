package com.growskill.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.model.Course;
import com.growskill.model.Customer;
import com.growskill.model.Payment;
import com.growskill.repository.PaymentRepository;
import com.growskill.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
    private PaymentRepository paymentRepository;
	
	public void processPayment(Customer customer, Course course, long amount) {
        // Dummy logic for processing payment
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setPaymentMethod("Dummy Payment Method");
        payment.setPaymentDate(LocalDateTime.now());

        // Save payment details
        paymentRepository.save(payment);

        // Update customer's enrolled courses
        customer.getEnrolledCourses().add(course);

        // Update course's enrolled customers
        course.getEnrolledCustomers().add(customer);
    }

}
