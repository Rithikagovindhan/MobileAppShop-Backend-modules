package com.example.mobileapp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentImplementation implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Payment processpayment(Payment newPayment) throws PaymentException {
        try {
            return this.paymentRepository.save(newPayment);
        } catch (Exception e) {
            throw new PaymentException("Error creating product: " + e.getMessage());
        }
    }
    @Override
    public Payment cancelpaymentById(Integer id) throws PaymentException {
        try {
            Optional<Payment> paymentopt = this.paymentRepository.findById(id);
            this.paymentRepository.deleteById(id);
            if (paymentopt.isEmpty()) {
                throw new ChangeSetPersister.NotFoundException();
            }
            return paymentopt.get();
        } catch (Exception e){
            throw new PaymentException("Error deleting product: " + e.getMessage());
        }
    }
    @Override
    public Optional<Payment> getPaymentdetails(Integer id) throws PaymentException {
        try {
            return this.paymentRepository.findById(id);
        } catch (Exception e) {
            throw new PaymentException("Error deleting product: " + e.getMessage());
        }
    }
}
