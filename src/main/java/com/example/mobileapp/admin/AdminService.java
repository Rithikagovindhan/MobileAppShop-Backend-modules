package com.example.mobileapp.admin;
import com.example.mobileapp.customer.Customer;
import com.example.mobileapp.product.Product;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface AdminService {
    Admin createAdmin(Admin newAdmin);
    String login(String email, String password);
    Admin updateAdmin(Admin updatedAdmin);
//    Customer getCustomerById(Integer Id) throws AdminExceptions;
    Product addProduct(Product newProduct) throws AdminExceptions;
    Admin updateProduct(Admin account) throws AdminExceptions;
    Product getProductById(Integer accountId) throws AdminExceptions;
    Product deleteProductById(Integer accountId) throws AdminExceptions;
    List<Product> getAllProducts() throws AdminExceptions;
    List<Customer> getAllCustomers() throws AdminExceptions;
}