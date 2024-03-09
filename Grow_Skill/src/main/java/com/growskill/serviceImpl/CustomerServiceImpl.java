package com.growskill.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.model.Customer;
import com.growskill.repository.CustomerRepository;
import com.growskill.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
    private CustomerRepository customerRepository;

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

}
