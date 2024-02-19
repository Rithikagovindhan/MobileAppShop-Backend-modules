package com.example.mobileapp.cart;
import com.example.mobileapp.product.product;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface CartService {
    Cart addToCart(Cart addProduct);
    Cart removeFromCart(Cart removeProduct);

    Cart updateToCart(Cart updateProducts);

    Cart getCartTotal(Cart totalCost);


}
