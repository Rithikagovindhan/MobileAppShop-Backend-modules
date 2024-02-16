package com.example.mobileapp.cart;


import java.util.ArrayList;
import java.util.List;

import com.example.mobileapp.product.product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class cart {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany
    private List<product> products = new ArrayList<>();


    public cart() {
        super();
    }

    public cart(Integer id, List<product> products) {
        super();
        this.id = id;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<product> getProducts() {
        return products;
    }

    public void setProducts(List<product> products) {
        this.products = products;
    }

}