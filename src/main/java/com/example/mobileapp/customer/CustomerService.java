package com.example.mobileapp.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {


    List<Customer> getAllCustomers();

    List<Customer> getCustomerById(Integer id);

    Customer createCustomer(Customer newCustomer);

    Customer updateCustomer(Customer updatedCustomer);

    Customer deleteCustomerById(Integer id);
    String login(String email,String password);

}