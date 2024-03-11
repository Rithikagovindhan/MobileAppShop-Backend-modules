package com.example.mobileapp.product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Product createProduct(Product newProduct)throws ProductExceptions;
    List<Product> getAllProducts() throws ProductExceptions;
    void deleteProduct(Integer id)throws ProductExceptions;
     Optional<Product> searchProduct(Integer productId) throws ProductExceptions;
}
