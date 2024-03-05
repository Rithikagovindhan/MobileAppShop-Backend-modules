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
    @PostMapping("addproductByAdmin")
    public Admin addProduct(@RequestBody Admin product) throws AdminExceptions {
        return this.adminService.addProduct(product);
    }
    @DeleteMapping("deleteProduct/{id}")
    public Product deleteProduct(@PathVariable Integer id) throws AdminExceptions{
        return this.adminService.deleteProductById(id);
    }
    @PostMapping("createAdminAccount")
    public Admin createAdmin(@RequestBody Admin newAccount) throws AdminExceptions {
        return this.adminService.createAdmin(newAccount);
    }
    @GetMapping("getProductsByAdmin")
    public List<Product> getAllProducts() throws AdminExceptions{
        return this.adminService.getAllProducts();
    }
     @GetMapping("getProduct/{id}")
     public Product getProduct(@PathVariable Integer id) throws AdminExceptions{
        return this.adminService.getProductById(id);
    }
    @GetMapping("customers")
    public List<Customer> getAllCustomers() throws AdminExceptions{
        return this.adminService.getAllCustomers();
    }
}





//    @PostMapping("newProduct")
//    public Admin createNewProduct(@RequestBody Admin newProduct){
//        Admin product=null;
//        try {
//            product = this.adminService.createNewProduct(newProduct);
//        } catch (AdminExceptions e) {
//            e.printStackTrace();
//        }
//        return product;
//    }
//@PostMapping("newProduct")
//public Admin createNewProduct(@RequestBody Admin adminProduct) throws AdminExceptions {
//    return this.adminService.createNewProduct(adminProduct);
//}

//    @PostMapping("addproductByAdmin")
//    public Admin createNewProduct(@RequestBody Admin product) throws AdminExceptions {
//        return this.adminService.createNewProduct(product);
//    }