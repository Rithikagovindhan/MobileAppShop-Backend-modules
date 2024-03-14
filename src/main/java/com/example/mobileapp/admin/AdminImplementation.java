package com.example.mobileapp.admin;
import com.example.mobileapp.customer.Customer;
import com.example.mobileapp.customer.CustomerRepository;
import com.example.mobileapp.product.Product;
import com.example.mobileapp.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class AdminImplementation implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Admin createAdmin(Admin newAdmin) {
        return adminRepository.save(newAdmin);
    }
    @Override
    public String login(String email, String password) {
        Optional<Admin> adminOptional = adminRepository.findByEmailAndPassword(email, password);
        if (adminOptional.isPresent()) {
            return "Admin login successful";
        }
        return null;
    }
    @Override
    public Admin updateAdmin(Admin updatedAdmin) {
        Optional<Admin> existingAdminOptional = adminRepository.findById(updatedAdmin.getId());
        if (existingAdminOptional.isPresent()) {
            Admin existingAdmin = existingAdminOptional.get();
            existingAdmin.setName(updatedAdmin.getName());
            existingAdmin.setEmail(updatedAdmin.getEmail());
            return adminRepository.save(existingAdmin);
        }
        return null;
    }
    @Override
    public Product addProduct(Product product) throws AdminExceptions {
        try {
            return this.productRepository.save(product);
        } catch (Exception e) {
            throw new AdminExceptions("Can't add the product: " + e.getMessage());
        }
    }
    @Override
    public Admin updateProduct(Admin account) throws AdminExceptions {
        try {
            return this.adminRepository.save(account);
        }
        catch (Exception e)
        {
            throw new AdminExceptions("Can't update the product by Id: "+e.getMessage());
        }
    }
    @Override
    public Product getProductById(Integer Id) throws AdminExceptions {
        try {
            return this.productRepository.findById(Id).get();
        } catch (Exception e) {
            throw new AdminExceptions("Can't retrieve the product by Id: " + e.getMessage());
        }
    }
//    @Override
//    public Customer getCustomerById(Integer Id) throws AdminExceptions {
//        try {
//            return this.customerRepository.findById(Id).get();
//        } catch (Exception e) {
//            throw new AdminExceptions("Can't retrieve the customer by Id: " + e.getMessage());
//        }
//    }
    @Override
    public Product deleteProductById(Integer Id) throws AdminExceptions {
        try {
            return this.productRepository.findById(Id).get();
        } catch (Exception e) {
            throw new AdminExceptions("Can't delete the product by id: " + e.getMessage());
        }
    }
    @Override
    public List<Product> getAllProducts() throws AdminExceptions {
        try {
            return this.productRepository.findAll();
        } catch (Exception e) {
            throw new AdminExceptions("Can't retrieve all products: " + e.getMessage());
        }
    }
    @Override
    public List<Customer> getAllCustomers() throws AdminExceptions {
        try {
            return this.customerRepository.findAll();
        } catch (Exception e) {
            throw new AdminExceptions("Can't retrieve all customers: " + e.getMessage());
        }
    }
}