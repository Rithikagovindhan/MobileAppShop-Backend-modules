
 package com.example.mobileapp.admin;
import com.example.mobileapp.admin.Admin;
import com.example.mobileapp.admin.AdminService;
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
    @PostMapping("addproductByAdmin")
    public Product addNewProduct(@RequestBody Product product) {
        return this.adminService.addProduct(product);
    }
    @GetMapping("getProductsByAdmin")
    public List<Product> getAllProducts(){
        return this.adminService.getAllProducts();
    }
    // @GetMapping("getProductsByAdmin")
// public List<Product> getAllProducts(@PathVariable Integer id){
// return (List<Product>) this.adminService.getProductById(id);
// }
    @GetMapping("customers")
    public List<Customer> getAllCustomers(){
        return this.adminService.getAllCustomers();
    }
    @PostMapping("createAdminAccount")
    public Admin createAdmin(@RequestBody Admin account) throws AdminExceptions {
        return this.adminService.createAdmin(account);
    }
    @DeleteMapping("account/{id}")
    public Product deleteProductById(@PathVariable Integer id) {
        return this.adminService.deleteProductById(id);
    }
}


// @PostMapping("addproductByadmin")
// public Admin createAccount(@RequestBody Admin addProducts) {
// return this.adminService.addProduct(addProducts);
// }
// @PutMapping("updatebyAdmin/product")
// public Admin updateAccount(@RequestBody Admin updateProducts) {
// return this.adminService.updateProduct(updateProducts);
// }

