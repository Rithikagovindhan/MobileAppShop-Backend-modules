package com.example.mobileapp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class productController {
    @Autowired
    private ProductService productservice;
    // Api to Account registration with email
    @PostMapping("product")
    public product createAccount(@RequestBody product products) {
        return this.productservice.createProduct(products);
    }
    @PutMapping("update/product")
    public product updateAccount(@RequestBody product products) {
        return this.productservice.updateProduct(products);
    }
    @GetMapping("product/{id}")
    public product getAccountById(@PathVariable("id") Integer accountId) {
        return this.productservice.getAccountById(accountId);
    }


}
