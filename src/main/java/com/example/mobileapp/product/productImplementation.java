package com.example.mobileapp.product;

import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class productImplementation implements ProductService {
    private ProductRepository productRepository;

    @Override
    public product createProduct(product newProduct) {

        return this.productRepository.save(newProduct);
    }

    @Override
    public Optional<product> getProductById(Integer id) {
        return this.productRepository.findById(id);
    }

    @Override
    public product updateProduct(product products) {
        return this.productRepository.save(products);
    }


    @Override
    public product getAccountById(Integer accountId) {
        return null;
    }
}
