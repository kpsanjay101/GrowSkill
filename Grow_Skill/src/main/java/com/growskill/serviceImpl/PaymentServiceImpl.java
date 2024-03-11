package com.growskill.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.exceptionHandler.PaymentException;
import com.growskill.model.Course;
import com.growskill.model.Customer;
import com.growskill.model.Payment;
import com.growskill.repository.PaymentRepository;
import com.growskill.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
    private PaymentRepository paymentRepository;
	
	@Override
	public boolean processPayment(long amount, Course course) {
        // Dummy logic for processing payment
        Payment payment = new Payment();
        if(course.getCourseAmount() != amount) {
        	throw new PaymentException("Please Enter correct Amount");
        }
        payment.setAmount(amount);
        payment.setPaymentMethod("Dummy Payment Method");
        payment.setPaymentDateTime(LocalDateTime.now());
        
        Payment savePayment = paymentRepository.save(payment);

         if(savePayment != null) return true;
         else return false;
    }

}
