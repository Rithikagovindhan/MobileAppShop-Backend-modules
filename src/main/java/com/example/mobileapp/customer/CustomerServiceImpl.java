package com.example.mobileapp.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer newCustomer) {

        return this.customerRepository.save(newCustomer);
    }
    @Override
    public boolean isEmailExists(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new CustomerNotFoundException("Customer not found");
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer updateCustomer(Integer customerId, Customer updatedCustomer) {
        if (!customerRepository.existsById(customerId)) {
            throw new CustomerNotFoundException("Customer not found");
        }

        updatedCustomer.setId(customerId);
        return customerRepository.save(updatedCustomer);
    }
}