package com.example.mobileapp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImplementation implements ProductService {
    @Autowired
    private ProductRepository productRepository;



    @Override
    public Product createProduct(Product newProduct) throws ProductExceptions {
        try {
            return this.productRepository.save(newProduct);
        } catch (Exception e) {
            throw new ProductExceptions("Error creating product: " + e.getMessage());
        }
    }

    @Override
    public List<Product> getAllProducts() throws ProductExceptions {
        try {
            return this.productRepository.findAll();
        } catch (Exception e) {
            throw new ProductExceptions("Error getting all products :" + e.getMessage());
        }
    }

    @Override
    public void deleteProduct(Integer id) throws ProductExceptions {
        try {
            this.productRepository.deleteById(id);
        } catch (Exception e) {
            throw new ProductExceptions("Error deleting product: " + e.getMessage());
        }
    }

    @Override
    public Optional<Product> searchProduct(Integer productId) throws ProductExceptions {
        try {
            return this.productRepository.findById(productId);
        } catch (Exception e) {

                throw new ProductExceptions("Error searching product: " + e.getMessage());
            }
        }


    }
