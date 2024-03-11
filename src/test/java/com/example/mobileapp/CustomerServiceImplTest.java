package com.example.mobileapp;

import com.example.mobileapp.customer.Customer;
import com.example.mobileapp.customer.CustomerRepository;
import com.example.mobileapp.customer.CustomerServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void testGetAllCustomers() {
        // Arrange
        Mockito.when(customerRepository.findAll()).thenReturn(Arrays.asList(new Customer(), new Customer()));

        // Act
        List<Customer> customers = customerService.getAllCustomers();

        // Assert
        assert customers != null;
        assert customers.size() == 2;
    }

    @Test
    public void testGetCustomerById() {
        // Arrange
        Integer customerId = 1;
        Mockito.when(customerRepository.findById(customerId)).thenReturn(Optional.of(new Customer()));

        // Act
        List<Customer> customerList = customerService.getCustomerById(customerId);

        // Assert
        assert customerList != null;
        assert customerList.size() == 1;
    }

    @Test
    public void testUpdateCustomer() {
        // Arrange
        Customer existingCustomer = new Customer(1, "John Doe", "john@example.com", "password", "Male", "123 Main St");
        Customer updatedCustomer = new Customer(1, "Updated Name", "updated@example.com", "updatedPassword", "Female", "456 New St");
        Mockito.when(customerRepository.findById(existingCustomer.getId())).thenReturn(Optional.of(existingCustomer));
        Mockito.when(customerRepository.save(existingCustomer)).thenReturn(updatedCustomer);

        // Act
        Customer result = customerService.updateCustomer(updatedCustomer);

        // Assert
        assert result != null;
        assert result.getName().equals("Updated Name");
        assert result.getEmail().equals("updated@example.com");
    }

    @Test
    public void testDeleteCustomerById() {
        // Arrange
        Integer customerId = 1;
        Customer deletedCustomer = new Customer(1, "John Doe", "john@example.com", "password", "Male", "123 Main St");
        Mockito.when(customerRepository.findById(customerId)).thenReturn(Optional.of(deletedCustomer));

        // Act
        Customer result = customerService.deleteCustomerById(customerId);

        // Assert
        assert result != null;
        assert result.getId().equals(customerId);
    }

    @Test
    public void testCreateCustomer() {
        // Arrange
        Customer newCustomer = new Customer(null, "New Customer", "new@example.com", "newPassword", "Female", "789 Street");
        Mockito.when(customerRepository.save(newCustomer)).thenReturn(newCustomer);

        // Act
        Customer result = customerService.createCustomer(newCustomer);

        // Assert
        assert result != null;
        assert result.getName().equals("New Customer");
        assert result.getEmail().equals("new@example.com");
    }

    @Test
    public void testLogin() {
        // Arrange
        String email = "john@example.com";
        String password = "password";
        Mockito.when(customerRepository.findByEmailAndPassword(email, password)).thenReturn(Optional.of(new Customer()));

        // Act
        String loginResult = customerService.login(email, password);

        // Assert
        assert loginResult != null;
        assert loginResult.equals("Customer login successful");
    }
}