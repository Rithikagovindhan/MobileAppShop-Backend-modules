package com.example.mobileapp.product;

import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class ProductImplementation implements ProductService {

    private ProductRepository productRepository;;

    @Override
    public Product createProduct(Product newProduct) {

        return this.productRepository.save(newProduct);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Product products) {
        return this.productRepository.save(products);
    }

    @Override
    public Product deleteProduct(Integer id) {
        return null;
    }

}
