package com.example.mobileapp.cart;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Integer> {

}
