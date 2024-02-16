package com.example.mobileapp.customer;

import org.springframework.stereotype.Service;
@Service
public interface CustomerService {

    Customer createCustomer(Customer newCustomer);
}
