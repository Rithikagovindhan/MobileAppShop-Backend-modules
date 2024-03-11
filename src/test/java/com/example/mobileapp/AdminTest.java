package com.example.mobileapp;
import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import com.example.mobileapp.admin.*;
import com.example.mobileapp.customer.Customer;
import com.example.mobileapp.customer.CustomerRepository;
import com.example.mobileapp.customer.CustomerService;
import com.example.mobileapp.customer.CustomerServiceImpl;
import com.example.mobileapp.product.*;
import org.junit.jupiter.api.Assertions;
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
    @InjectMocks
    private AdminService adminService = new AdminImplementation();
    @InjectMocks
    private ProductService productService=new ProductImplementation();
    @InjectMocks
    private CustomerService customerService=new CustomerServiceImpl();
    @Test
    void testCreateAdmin_Success() throws AdminExceptions {
        Admin newAdmin = new Admin(1, "John Doe", "johndoe@example.com", "password");
        when(adminRepository.findByEmail("johndoe@example.com")).thenReturn(Optional.empty());
        when(adminRepository.save(newAdmin)).thenReturn(newAdmin);
        Admin createdAdmin = adminService.createAdmin(newAdmin);
        assertEquals(newAdmin, createdAdmin);
    }
    @Test
    void testCreateAdmin_EmailAlreadyExists() {
        Admin existingAdmin = new Admin(1, "Jane Smith", "janesmith@example.com", "password");
        when(adminRepository.findByEmail("janesmith@example.com")).thenReturn(Optional.of(existingAdmin));
        Admin newAdmin = new Admin(2, "John Doe", "janesmith@example.com", "password");
        try {
            adminService.createAdmin(newAdmin);
            fail("Expected AdminExceptions to be thrown");
        } catch (AdminExceptions e) {
            assertEquals("Email already registered, please re try.janesmith@example.com", e.getMessage());
        }
    }
    @Test
    void testLogin_Success() throws AdminExceptions{
        String userEmail = "johndoe@example.com";
        String userPassword = "password";
        Admin existingAdmin = new Admin(1, "John Doe", "johndoe@example.com", "password");
        when(adminRepository.findByEmail(userEmail)).thenReturn(Optional.of(existingAdmin));
        Admin loggedInAdmin = adminService.login(userEmail, userPassword);
        assertEquals(existingAdmin, loggedInAdmin);
    }

    @Test
    void testLogin_AccountDoesNotExist() {
        String userEmail = "nonexistent@example.com";
        String userPassword = "password";
        when(adminRepository.findByEmail(userEmail)).thenReturn(Optional.empty());
        try {
            adminService.login(userEmail, userPassword);
            fail("Expected AdminExceptions to be thrown");
        } catch (AdminExceptions e) {
            Assertions.assertEquals("Account does not exist for :nonexistent@example.com", e.getMessage());
        }
    }
//    @Test
//    void testAddProduct_Success() throws AdminExceptions{
//        Admin newProduct = new Product(1, "vivo", "Y15", 150000.0,"red",2);
//        when(productRepository.save(newProduct)).thenReturn(newProduct);
//        Admin addedProduct = adminService.createNewProduct(adminProduct);
//        assertEquals(newProduct, addedProduct);
//    }
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
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        Product retrievedProduct = adminService.getProductById(productId);
        assertEquals(product, retrievedProduct);
    }
    @Test
    void testGetAllProducts_Success() throws AdminExceptions{
        List<Product> productList = Arrays.asList(
                new Product()
        );
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> retrievedProducts = adminService.getAllProducts();
        assertEquals(productList, retrievedProducts);
    }
//    @Test
//    public void testFindAllProductsContainingName_Success() throws AdminExceptions{
//        String queryName = "Product";
//        List<Product> productList = Arrays.asList(
//                new Product(1, "vivo", "Y15",150000.0,"red",2),
//                );
//        when(productRepository.findById(Integer.valueOf(queryName))).thenReturn(productList);
//        List<Product> retrievedProducts = adminService.findAllProductsContainingName(queryName);
//        assertEquals(productList, retrievedProducts);
//    }
    @Test
    void testGetAllCustomers_Success() throws AdminExceptions{
        List<Customer> customerList = Arrays.asList(
                new Customer(1, "Alice", "alice@example.com","alice123","male","ywavcmhagvf")
        );
        when(customerRepository.findAll()).thenReturn(customerList);
        List<Customer> retrievedCustomers = adminService.getAllCustomers();
        assertEquals(customerList, retrievedCustomers);
    }
    @Test
    void testDeleteProductById_Success() throws AdminExceptions{
        Integer productId = 1;
        Product product = new Product();
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        Product deletedProduct = adminService.deleteProductById(productId);
        assertEquals(product, deletedProduct);
        verify(productRepository, times(1)).deleteById(productId);
    }
}
