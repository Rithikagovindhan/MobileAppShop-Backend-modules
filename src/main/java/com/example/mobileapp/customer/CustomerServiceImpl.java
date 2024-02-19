package com.example.mobileapp.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer newCustomer) {

        return this.customerRepository.save(newCustomer);
    }
}
