package com.example.mobileapp.payment;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PaymentService {
    Payment processpayment(Payment newPayment) throws PaymentException;
    Payment cancelpaymentById(Integer id) throws PaymentException;
    Optional<Payment> getPaymentdetails(Integer id) throws PaymentException;

}
