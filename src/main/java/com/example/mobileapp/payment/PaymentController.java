package com.example.mobileapp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("processPayment")
    public Payment processpayment(@RequestBody Payment newPayment) throws PaymentException {
        return this.paymentService.processpayment(newPayment);
    }
    @DeleteMapping("payment/{id}")
    public Payment cancelpaymentById(@PathVariable Integer id) throws PaymentException {
        return this.paymentService.cancelpaymentById(id);
    }
    @GetMapping("getpayment/{id}")
    public Optional<Payment> getPaymentdetails(@PathVariable("id") Integer id) throws PaymentException {
        return this.paymentService.getPaymentdetails(id);
    }

}
