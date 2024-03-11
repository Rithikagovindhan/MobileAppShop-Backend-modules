package com.example.mobileapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomerById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.map(List::of).orElse(List.of());
    }

    @Override
    public Customer updateCustomer(Customer updatedCustomer) {
        Optional<Customer> existingCustomerOptional = customerRepository.findById(updatedCustomer.getId());

        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setGender(updatedCustomer.getGender());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            return customerRepository.save(existingCustomer);
        }

        return null; // Customer not found
    }

    @Override
    public Customer deleteCustomerById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isPresent()) {
            Customer deletedCustomer = customerOptional.get();
            customerRepository.delete(deletedCustomer);
            return deletedCustomer;
        }

        return null; // Customer not found
    }

    @Override
    public Customer createCustomer(Customer newCustomer) {
        // Additional validation logic can be added here
        return customerRepository.save(newCustomer);

    }

    @Override
    public String login(String email, String password) {
        Optional<Customer> customerOptional = customerRepository.findByEmailAndPassword(email, password);

        if (customerOptional.isPresent()) {
            return "Customer login successful";
        }

        return null;

    }
}
