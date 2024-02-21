package com.example.mobileapp.product;

import com.example.mobileapp.admin.Admin;
import com.example.mobileapp.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
@Autowired
    private ProductService productService;
    @PostMapping("product")
    public Product addNewProduct(@RequestBody Product product) throws productExceptions {
        return this.productService.createProduct(product);
    }
    @GetMapping("product")
    public List<Product> getAllProducts() throws productExceptions {
        return this.productService.getAllProducts();
    }
   @DeleteMapping("removeProduct/{productId}")
 public void removeProduct(@PathVariable Integer productId) throws productExceptions {
        this.productService.deleteProduct(productId);
    }
}
