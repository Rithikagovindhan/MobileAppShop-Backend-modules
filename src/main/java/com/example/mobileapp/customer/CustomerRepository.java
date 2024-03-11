package com.example.mobileapp.customer;


import com.example.mobileapp.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByEmail(String email);

    Customer deleteCustomerById(Integer id);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByEmailAndPassword(String email,String Password);

}