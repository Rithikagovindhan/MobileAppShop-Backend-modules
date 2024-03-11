package com.example.mobileapp.cart;


import java.util.ArrayList;
import java.util.List;
import com.example.mobileapp.product.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import com.example.mobileapp.product.Product;
import jakarta.persistence.*;
@Entity

@Table(name="CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer cartId;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @ManyToMany


    @Column(name = "Product details")
    private List<Product> products = new ArrayList<>();


    public Cart() {
        super();
    }

    public Cart(Integer cartId, Integer quantity, List<Product> products) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.products = products;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}