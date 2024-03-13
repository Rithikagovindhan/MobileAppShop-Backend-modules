package com.example.mobileapp.payment;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="PAYMENT")
public class Payment {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Integer id;
    @Column(name="PAYMENTDATE")
    private LocalDate paymentDate;
    @Column(name="TYPE")
    private String type;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Payment(Integer id, LocalDate paymentDate, String type) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Payment(){
        super();
    }




}

