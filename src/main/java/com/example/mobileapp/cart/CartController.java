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
    private List<Product> products = new ArrayList<>();
    @PostMapping("Cart")
    public Cart addProducts(@RequestBody Cart products){
        return this.cartService.addToCart(products);
    }
    @PutMapping("updateProduct")
    public Cart updateCart(@RequestBody Cart products) {
        return this.cartService.updateToCart(products);
    }
    @GetMapping("/api/cartTotal")
    public double getCartTotal() {
        double total = 0;
        for (Product item : products) {
            total += item.getPrice();
        }
        return total;
    }
}
