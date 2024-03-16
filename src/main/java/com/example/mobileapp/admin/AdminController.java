package com.example.mobileapp.admin;
import com.example.mobileapp.customer.CustomerService;
import com.example.mobileapp.product.Product;
import com.example.mobileapp.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.mobileapp.customer.Customer;
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @PostMapping("createAdmin")
    public Admin createAdmin(@RequestBody Admin newAdmin) {
        return adminService.createAdmin(newAdmin);
    }
    @PutMapping("updateAdmin")
    public Admin updateAdmin(@RequestBody Admin updatedAdmin) {
        return adminService.updateAdmin(updatedAdmin);
    }
        @PutMapping("updateProductByAdmin")
        public Product updateProduct(@RequestBody Product updatedProduct) {
            try {
                return adminService.updateProduct(updatedProduct);
            } catch (AdminExceptions e) {
                return null;
            }
        }
    @PostMapping("adminLogin")
    public String login(@RequestParam String email, @RequestParam String password) {
        String loginResult = adminService.login(email, password);
        if (loginResult != null) {
            return loginResult;
        } else {
            return "Admin not found or invalid credentials.Try again!!";
        }
    }
    @PostMapping("AddProduct")
    public Product addNewProduct(@RequestBody Product product) throws AdminExceptions {
        return this.adminService.addProduct(product);
    }
    @DeleteMapping("deleteProduct/{id}")
    public Product deleteProduct(@PathVariable Integer id) throws AdminExceptions {
        return this.adminService.deleteProductById(id);
    }
    @GetMapping("getAllProducts")
    public List<Product> getAllProducts() throws AdminExceptions {
        return this.adminService.getAllProducts();
    }
    @GetMapping("getProduct/{id}")
    public Product getProduct(@PathVariable Integer id) throws AdminExceptions {
        return this.adminService.getProductById(id);
    }
    @GetMapping("getCustomers")
    public List<Customer> getAllCustomers() throws AdminExceptions {
        return this.adminService.getAllCustomers();
    }
}