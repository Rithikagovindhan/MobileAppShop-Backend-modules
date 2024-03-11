package com.example.mobileapp.customer;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mobileapp.customer.Customer;
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("getCustomerById/{id}")
    public List<Customer> getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("updateCustomer")
    public Customer updateCustomer(@RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(updatedCustomer);
    }

    @DeleteMapping("deleteCustomer/{id}")
    public Customer deleteCustomerById(@PathVariable Integer id) {
        return customerService.deleteCustomerById(id);
    }

    @PostMapping("createCustomer")
    public Customer createCustomer(@RequestBody Customer newCustomer) {
        return customerService.createCustomer(newCustomer);
    }
    @PostMapping("login")
    public String login(@RequestParam String email, @RequestParam String password) {
        String loginResult = customerService.login(email, password);

        if (loginResult != null) {
            return loginResult;
        } else {
            // Redirect to the create customer page or handle as per your UI flow
            return "Customer not found or invalid credentials. Redirect to create customer page.";
        }
    }

}