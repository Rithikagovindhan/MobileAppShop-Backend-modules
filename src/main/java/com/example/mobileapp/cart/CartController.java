package com.example.mobileapp.cart;

import com.example.mobileapp.product.ProductService;
import com.example.mobileapp.product.product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class CartController {

    @Autowired
    private CartService cartService;
    private List<product> products = new ArrayList<>();
  //  private List<product> cartItems = new ArrayList<>();


    @PostMapping("Cart")
    public Cart addProducts(@RequestBody Cart products){
        return this.cartService.addToCart(products);
    }
    @DeleteMapping("removeProduct")
    public Cart removeProduct(@RequestBody Cart products) {
        return this.cartService.removeFromCart(products);

    }
    @PutMapping("updateProduct")
    public Cart updateProduct(@RequestBody Cart products) {
        return this.cartService.updateToCart(products);

    }
    @GetMapping("/api/cartTotal")
    public double getCartTotal() {
        double total = 0;
        for (product item : products) {
            total += item.getPrice();
        }
        return total;

    }
}
