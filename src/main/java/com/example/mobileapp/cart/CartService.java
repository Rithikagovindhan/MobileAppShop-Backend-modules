package com.example.mobileapp.cart;

import org.springframework.stereotype.Service;
@Service
public interface CartService {
    Cart addToCart(Cart addProduct);
    Cart removeFromCart(Cart removeProduct);

    Cart updateToCart(Cart updateProducts);

    Cart getCartTotal(Cart totalCost);


}
