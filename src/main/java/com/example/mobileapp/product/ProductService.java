package com.example.mobileapp.product;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface ProductService {
    Product createProduct(Product newProduct);
    Optional<Product> getProductById(Integer id);
    Product updateProduct(Product products);


}
