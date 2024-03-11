package com.example.mobileapp;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.example.mobileapp.product.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductImplementation productImplementation;
    @InjectMocks
    private ProductService productService = new ProductImplementation();


    @InjectMocks
    private ProductController productController;

    @Test
    void testCreateProduct() throws ProductExceptions {
        // Create a new product
        Product newProduct = new Product(1, "Vivo", "Y50", 17000.00, "Blue", 2);
        // Mock the behavior of the productRepository.save method
        when(productRepository.save(newProduct)).thenReturn(newProduct);
        // Perform the test
        Product createdProduct = productService.createProduct(newProduct);
        // Assertions
        assertEquals(newProduct, createdProduct);
        // Add more assertions as needed
    }
    @Test
    public void testCreateProduct_ExceptionThrown() {
        // Create a sample product to be saved
        Product newProduct = new Product(1, "Vivo", "Y50", 17000.00, "Blue", 2);

        // Mock the behavior of productRepository.save() to throw an exception
        when(productRepository.save(newProduct)).thenThrow(new RuntimeException("Database connection error"));

        // Perform creating a new product and catch the exception
        try {
            productService.createProduct(newProduct);
        } catch (ProductExceptions e) {
            // Validate that the exception message contains the expected error message
            assertEquals("Error creating product: Database connection error", e.getMessage());
        }
    }
    @Test
    void testGetAllProducts() throws ProductExceptions {
        // Create a list of mock products
        List<Product> mockProducts = Collections.singletonList(new Product(1, "Vivo", "Y50", 17000.00, "Blue", 2));
        // Mock the behavior of the productRepository.findAll method
        when(productRepository.findAll()).thenReturn(mockProducts);
        // Perform the test
        List<Product> retrievedProducts = productService.getAllProducts();
        // Assertions
        assertEquals(mockProducts, retrievedProducts);
    }
    @Test
    void testGetAllProducts_EmptyList() throws ProductExceptions {
        // Mock the behavior of productRepository.findAll() to return an empty list
        when(productRepository.findAll()).thenReturn(new ArrayList<>());

        // Perform getting all products
        List<Product> result = productService.getAllProducts();

        // Validate that the result is an empty list
        assertEquals(0, result.size());
    }
    @Test
    public void testGetAllProducts_Success() throws ProductExceptions {
        // Create a list of sample products
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Vivo", "Y50", 17000.00, "Blue", 2));
        productList.add(new Product(2, "Samsung", "S23", 23000.00, "Blue", 2));

        // Mock the behavior of productRepository.findAll() to return the sample product list
        when(productRepository.findAll()).thenReturn(productList);

        // Perform getting all products
        List<Product> result = productService.getAllProducts();

        // Validate that the result matches the sample product list
        assertEquals(productList, result);
    }
    @Test
     void testGetAllProducts_ExceptionThrown() {
        // Mock the behavior of productRepository.findAll() to throw an exception
        when(productRepository.findAll()).thenThrow(new RuntimeException("Database connection error"));

        // Perform getting all products and catch the exception
        try {
            productService.getAllProducts();
        } catch (ProductExceptions e) {
            // Validate that the exception message contains the expected error message
            assertEquals("Error getting all products :Database connection error", e.getMessage());
        }
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
    @Test
    public void testDeleteProduct_ExceptionThrown() {
        // Mock the behavior of productRepository.deleteById() to throw an exception
        doThrow(new RuntimeException("Database connection error")).when(productRepository).deleteById(2);

        // Perform deleting a product and catch the exception
        try {
            productService.deleteProduct(2);
        } catch (ProductExceptions e) {
            // Validate that the exception message contains the expected error message
            assertEquals("Error deleting product: Database connection error", e.getMessage());
        }
    }


    @Test
    public void testProductConstructor() {
        Product product = new Product(1, "Vivo", "Y15", 150000.0, "Red", 2);

        assertEquals(1, product.getId());
        assertEquals("Vivo", product.getBrandName());
        assertEquals("Y15", product.getModelName());
        assertEquals(150000.0, product.getPrice());
        assertEquals("Red", product.getColor());
        assertEquals(2, product.getQuantity());
    }
    @Test
    public void testSettersAndGetters() {
        Product product = new Product();

        product.setId(1);
        product.setBrandName("Samsung");
        product.setModelName("Galaxy S20");
        product.setPrice(1200.0);
        product.setColor("Black");
        product.setQuantity(5);

        assertEquals(1, product.getId());
        assertEquals("Samsung", product.getBrandName());
        assertEquals("Galaxy S20", product.getModelName());
        assertEquals(1200.0, product.getPrice());
        assertEquals("Black", product.getColor());
        assertEquals(5, product.getQuantity());
    }
    @Test
     void testSearchProduct_Success() throws ProductExceptions {
        // Create a sample product
        Product product = new Product(1, "Vivo", "Y15", 150000.0, "Red", 2);

        // Mock the behavior of productRepository.findById() to return the sample product
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // Perform the search
        Optional<Product> result = productService.searchProduct(1);

        // Validate the result
        assertEquals(Optional.of(product), result);
    }

    @Test
    public void testSearchProduct_ProductNotFound() throws ProductExceptions {
        // Mock the behavior of productRepository.findById() to return an empty Optional
        when(productRepository.findById(2)).thenReturn(Optional.empty());

        // Perform the search
        Optional<Product> result = productService.searchProduct(2);

        // Validate that the result is empty
        assertEquals(Optional.empty(), result);
    }

    @Test
  void testSearchProduct_ExceptionThrown() {
        // Mock the behavior of productRepository.findById() to throw an exception
        when(productRepository.findById(3)).thenThrow(new RuntimeException("Database connection error"));

        // Perform the search and catch the exception
        try {
            productService.searchProduct(3);
        } catch (ProductExceptions e) {
            // Validate that the exception message contains the expected error message
            assertEquals("  Error searching product: Database connection error", e.getMessage());
        }

    }

}