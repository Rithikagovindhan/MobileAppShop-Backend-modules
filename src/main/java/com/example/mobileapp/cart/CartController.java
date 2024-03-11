package com.example.mobileapp.cart;

import com.example.mobileapp.product.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;
@RestController
public class CartController {
    @Autowired
    private CartService cartService;




    @GetMapping("getAllProductsInCart")
    public List<Cart> getAllCartProducts() throws CartExceptions{
        return this.cartService.getAllCartProducts();
    }
    @GetMapping("getCartProductByCartId/{cartId}")
    public List<Cart> getCartProductsByCartId(@PathVariable Integer cartId)throws CartExceptions{
        return cartService.getCartProductsByCartId(cartId);
    }
    @PostMapping("AddProductToCart")
    public Cart addProductToCart(@RequestBody Cart cart) throws CartExceptions {
        return this.cartService.addProductToCart(cart);
    }
    @DeleteMapping("cartProduct/{cartId}")
    public Cart deleteCartProductById(@PathVariable Integer cartId)throws CartExceptions{
        return this.cartService.deleteCartProductById(cartId);

    }



}


