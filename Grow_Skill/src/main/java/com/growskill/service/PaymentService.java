package com.growskill.service;

import com.growskill.model.Course;
import com.growskill.model.Customer;

public interface PaymentService {
	
	public void processPayment(Customer customer, Course course, long amount);

}
