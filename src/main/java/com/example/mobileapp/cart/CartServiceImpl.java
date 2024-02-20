package com.example.mobileapp.cart;

import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    private CartRepository cartRepository;
    @Override
    public Cart addToCart(Cart addProduct) {
        return this.cartRepository.save(addProduct);
    }

    @Override
    public Cart removeFromCart(Cart removeProduct) {

        return this.cartRepository.save(removeProduct);
    }

    @Override
    public Cart updateToCart(Cart updateProducts) {

        return this.cartRepository.save(updateProducts);
    }

    @Override
    public Cart getCartTotal(Cart totalCost) {
        return this.cartRepository.save(totalCost);
    }

    ;

}
