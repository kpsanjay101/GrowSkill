package com.growskill.service;

import java.util.List;

import com.growskill.model.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int customerId);
	public Customer saveCustomer(Customer customer);
	public String deleteCustomer(int customerId);
	
	
	

}
