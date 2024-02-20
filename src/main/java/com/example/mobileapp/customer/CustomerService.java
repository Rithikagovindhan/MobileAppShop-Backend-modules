package com.example.mobileapp.customer;

import org.springframework.stereotype.Service;
@Service
public interface CustomerService {

    Customer createCustomer(Customer newCustomer);

    boolean isEmailExists(String email);

    void deleteCustomer(Integer customerId);

    Customer updateCustomer(Integer customerId, Customer updatedCustomer);
}