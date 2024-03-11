package com.example.mobileapp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import com.example.mobileapp.product.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
@ExtendWith(MockitoExtension.class)
class ProductTest {
        @Mock
        private ProductRepository productRepository;
        @InjectMocks
    private ProductService productService = new ProductImplementation();
    @Test
    void testCreateProduct() throws ProductExceptions {
        // Create a new product
        Product newProduct = new Product();
        // Mock the behavior of the productRepository.save method
        when(productRepository.save(newProduct)).thenReturn(newProduct);
        // Perform the test
        Product createdProduct = productService.createProduct(newProduct);
        // Assertions
        assertEquals(newProduct, createdProduct);
        // Add more assertions as needed
    }
    @Test
    void testGetAllProducts() throws ProductExceptions {
        // Create a list of mock products
        List<Product> mockProducts = Collections.singletonList(new Product());
        // Mock the behavior of the productRepository.findAll method
        when(productRepository.findAll()).thenReturn(mockProducts);
        // Perform the test
        List<Product> retrievedProducts = productService.getAllProducts();
        // Assertions
        assertEquals(mockProducts, retrievedProducts);
    }
    @Test
    void testDeleteProduct() throws ProductExceptions {
        // Create a mock product ID
        Integer productId = 1;
        // Perform the test
        productService.deleteProduct(productId);
        // Verify that the productRepository.deleteById method was called with the expected ID
        verify(productRepository, times(1)).deleteById(productId);
    }
}
