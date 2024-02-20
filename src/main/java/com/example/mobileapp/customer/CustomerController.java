package com.example.mobileapp.customer;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("customer")
    public Customer createAccount(@Valid @RequestBody Customer newCustomer) {
        if (customerService.isEmailExists(newCustomer.getEmail())) {
            throw new DuplicateUserException("Email already exists");
        }
        return this.customerService.createCustomer(newCustomer);
    }
    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
    }
    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable Integer customerId, @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(customerId, updatedCustomer);
    }


}
