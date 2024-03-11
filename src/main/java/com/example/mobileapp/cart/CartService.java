package com.example.mobileapp.cart;


import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CartService {
    Cart addProductToCart(Cart cart) throws CartExceptions;

    Cart deleteCartProductById(Integer cartId) throws CartExceptions;

    List<Cart> getAllCartProducts() throws  CartExceptions;

    List<Cart> getCartProductsByCartId(Integer cartId) throws  CartExceptions;



}