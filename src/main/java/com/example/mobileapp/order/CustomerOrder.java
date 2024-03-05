package com.example.mobileapp.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.mobileapp.payment.Payment;
import com.example.mobileapp.product.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    @OneToOne
    private Payment payments;



    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public CustomerOrder() {
        super();
    }
    public CustomerOrder(Integer id, LocalDate orderDate, LocalDate deliveryDate, String status) {
        super();
        this.id = id;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }



}