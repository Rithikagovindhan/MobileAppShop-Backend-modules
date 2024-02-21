package com.example.mobileapp.product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ProductService {

    Product createProduct(Product newProduct)throws productExceptions;
    List<Product> getAllProducts() throws productExceptions;
    void deleteProduct(Integer id)throws productExceptions;

}
