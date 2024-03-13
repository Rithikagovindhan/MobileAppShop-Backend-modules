package com.example.mobileapp;

import com.example.mobileapp.payment.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentTest {
    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService = new PaymentImplementation();

    @Test
    void testprocesspayment() throws PaymentException {
        // Create a new payment
        Payment newPayment = new Payment(1, LocalDate.of(2024, 3, 27),"UPI");

        // Mock the behavior of the productRepository.save method
        when(paymentRepository.save(newPayment)).thenReturn(newPayment);

        // Perform the test
        Payment createdPayment = paymentService.processpayment(newPayment);

        // Assertions
        assertEquals(newPayment, createdPayment);
        // Add more assertions as needed
    }
    @Test
    void testgetPaymentdetails() throws PaymentException {
        // Create a list of mock products
        Integer Payid = 1;
        Payment newPayment = new Payment(1, LocalDate.of(2024, 3, 27),"UPI");


        // Mock the behavior of the productRepository.findAll method
        when(paymentRepository.findById(Payid)).thenReturn(Optional.of(newPayment));

        // Perform the test
        Optional<Payment> retrievedPayment = paymentService.getPaymentdetails(Payid);

        // Assertions
        assertEquals(Optional.of(newPayment), retrievedPayment);
    }

    @Test
    void testcancelpaymentById() throws PaymentException {
        // Create a mock product ID
        Integer paymentId = 1;


        Payment payment = new Payment(); // Create a dummy Payment object
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(payment));


        // Perform the test
        paymentService.cancelpaymentById(paymentId);

        // Verify that the productRepository.deleteById method was called with the expected ID
        verify(paymentRepository, times(1)).deleteById(paymentId);
    }
}
