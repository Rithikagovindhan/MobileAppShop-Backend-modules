package com.example.mobileapp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import com.example.mobileapp.admin.*;
import com.example.mobileapp.customer.Customer;
import com.example.mobileapp.customer.CustomerRepository;
import com.example.mobileapp.customer.CustomerService;
import com.example.mobileapp.customer.CustomerServiceImpl;
import com.example.mobileapp.product.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AdminTest {
    @Mock
    private AdminRepository adminRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private AdminImplementation adminImplementation;
    @InjectMocks
    private AdminService adminService = new AdminImplementation();
    @InjectMocks
    private ProductService productService = new ProductImplementation();
    @InjectMocks
    private CustomerService customerService = new CustomerServiceImpl();
    @Test
    void testCreateAdmin() {
        Admin newAdmin = new Admin(1, "Rithika", "rithikagovindhan@gmail.com", "rithika@123");
        when(adminRepository.save(any(Admin.class))).thenReturn(newAdmin);
        Admin createdAdmin = adminService.createAdmin(newAdmin);
        assertEquals("AdminName", createdAdmin.getName());
        verify(adminRepository, times(1)).save(newAdmin);
    }
    @Test
    void testLoginSuccess() {
        when(adminRepository.findByEmailAndPassword("rithikagovindhan@gmail.com", "rithika@123")).thenReturn(Optional.of(new Admin()));
        String loginResult = adminService.login("rithikagovindhan@gmail.com", "rithika@123");
        assertEquals("Admin login successful", loginResult);
    }
    @Test
    void testLoginFailure() {
        when(adminRepository.findByEmailAndPassword("rithikagovindhan@gmail.com", "invalid")).thenReturn(Optional.empty());
        String loginResult = adminService.login("rithikagovindhan@gmail.com", "invalid");
        assertNull(loginResult);
    }
    @Test
    void testUpdateAdmin() {
        Admin updatedAdmin = new Admin(1, "karthik", "karthik@gmail.com.com", "karthik@123");
        when(adminRepository.findById(1)).thenReturn(Optional.of(new Admin()));
        when(adminRepository.save(any(Admin.class))).thenReturn(updatedAdmin);
        Admin result = adminService.updateAdmin(updatedAdmin);
        assertEquals("UpdatedAdminName", result.getName());
    }
    @Test
    void testAddProduct() throws AdminExceptions {
        Product newProduct = new Product(1, "vivo", "Y15", 150000.0, "red", 2);
        when(productRepository.save(any(Product.class))).thenReturn(newProduct);
        Product addedProduct = adminService.addProduct(newProduct);
        assertEquals("New Product", addedProduct.getId());
    }
    @Test
    void testUpdateProduct_Success() throws AdminExceptions {
        Admin admin = new Admin(1, "John Doe", "johndoe@example.com", "password");
        when(adminRepository.save(admin)).thenReturn(admin);
        Admin updatedAdmin = adminService.updateProduct(admin);
        assertEquals(admin, updatedAdmin);
    }
    @Test
    void testGetProductById_Success() throws AdminExceptions {
        Integer productId = 1;
        Product product = new Product(1, "vivo", "Y15", 150000.0, "red", 2);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        Product retrievedProduct = adminService.getProductById(productId);
        assertEquals(product, retrievedProduct);
    }
    @Test
    void testDeleteProductById_Success() throws AdminExceptions{
        Integer productId = 1;
        Product product = new Product(1, "vivo", "Y15",150000.0,"red",2);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        Product deletedProduct = adminService.deleteProductById(productId);
        assertEquals(product, deletedProduct);
        verify(productRepository, times(1)).deleteById(productId);
    }
    @Test
    void testGetAllProducts_Success() throws AdminExceptions {
        List<Product> productList = Arrays.asList(
                new Product(1, "vivo", "Y15", 150000.0, "red", 2));
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> retrievedProducts = adminService.getAllProducts();
        assertEquals(productList, retrievedProducts);
    }
    @Test
    void testGetAllCustomers_Success() throws AdminExceptions {
        List<Customer> customerList = Arrays.asList(
                new Customer(1, "Alice", "alice@gmail.com", "alice123", "male", "xxx"));
        when(customerRepository.findAll()).thenReturn(customerList);
        List<Customer> retrievedCustomers = adminService.getAllCustomers();
        assertEquals(customerList, retrievedCustomers);
    }
}