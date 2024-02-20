package com.example.mobileapp.product;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface ProductService {
    product  createProduct(product newProduct);
    Optional<product> getProductById(Integer id);
    product updateProduct(product products);


    product getAccountById(Integer accountId);
}
