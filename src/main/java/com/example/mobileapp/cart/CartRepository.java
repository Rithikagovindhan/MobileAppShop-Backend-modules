package com.example.mobileapp.cart;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
