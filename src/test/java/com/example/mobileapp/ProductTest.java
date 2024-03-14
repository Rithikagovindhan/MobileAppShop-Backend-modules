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
        Product newProduct = new Product(1,"Vivo","Y50",17000.00,"Blue",2);
        when(productRepository.save(newProduct)).thenReturn(newProduct);
        Product createdProduct = productService.createProduct(newProduct);
        assertEquals(newProduct, createdProduct);
    }
    @Test
    void testGetAllProducts() throws ProductExceptions {
        // Create a list of mock products
        List<Product> mockProducts = Collections.singletonList(new Product(1,"Vivo","Y50",17000.00,"Blue",2));
        // Mock the behavior of the productRepository.findAll method
        when(productRepository.findAll()).thenReturn(mockProducts);
        // Perform the test
        List<Product> retrievedProducts = productService.getAllProducts();
        // Assertions
        assertEquals(mockProducts, retrievedProducts);
    }
    @Test
    void testDeleteProduct() throws ProductExceptions {
        Integer productId = 1;
        productService.deleteProduct(productId);
        verify(productRepository, times(1)).deleteById(productId);
    }
}
