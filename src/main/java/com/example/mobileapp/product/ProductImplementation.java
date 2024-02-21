package com.example.mobileapp.product;


import com.example.mobileapp.admin.Admin;
import com.example.mobileapp.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImplementation implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product newProduct) throws productExceptions {
        try {
            return this.productRepository.save(newProduct);
        } catch (Exception e) {
            throw new productExceptions("Error creating product: " + e.getMessage());
        }
    }

    @Override
    public List<Product> getAllProducts() throws productExceptions {
        try {
            return this.productRepository.findAll();
        } catch (Exception e) {
            throw new productExceptions("Error getting all products :" + e.getMessage());
        }
    }

    @Override
    public void deleteProduct(Integer id) throws productExceptions {
        try {
            this.productRepository.deleteById(id);
        } catch (Exception e) {
            throw new productExceptions("Error deleting product: " + e.getMessage());
        }

    }
}
