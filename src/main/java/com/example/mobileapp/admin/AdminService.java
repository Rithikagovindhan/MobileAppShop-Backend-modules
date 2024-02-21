package com.example.mobileapp.admin;
import com.example.mobileapp.customer.Customer;
import com.example.mobileapp.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    //    Admin addProduct(Admin addProduct);//CRUD
//    Optional<Product> getProductById(Integer id);
//    Admin updateProduct(Admin updateProducts);
//    Admin deleteProduct(Admin deleteProducts);
    Admin createAdmin(Admin newAccount) throws AdminExceptions;
    Admin login(String userEmail, String userPassword)throws AdminExceptions;
    Product addProduct(Product addProduct);
    Admin updateProduct(Admin account);
    Product getProductById(Integer accountId);
    Product deleteProductById(Integer id);
    List<Product> getAllProducts();
    List<Customer> getAllCustomers();
    List<Product> findAllProductsContainingName(String queryName);
}