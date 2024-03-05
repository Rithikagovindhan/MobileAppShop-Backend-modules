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
    public Admin createAdmin(Admin newAccount) throws AdminExceptions {
        Optional<Admin> accountOpt = this.adminRepository.findByEmail(newAccount.getEmail());
        if (accountOpt.isPresent())
            throw new AdminExceptions("Email already registered, please re try." + newAccount.getEmail());
        return this.adminRepository.save(newAccount);
    }
    @Override
    public Admin login(String userEmail, String userPassword) throws AdminExceptions {
        Optional<Admin> accountOpt = this.adminRepository.findByEmail(userEmail);
        if (accountOpt.isEmpty())
            throw new AdminExceptions("Account does not exists for :" + userEmail);
        Admin foundccount = accountOpt.get();
        if (!foundccount.getPassword().equals(userPassword))
            throw new AdminExceptions("Password does not match");
        return foundccount;
    }

    @Override
    public Admin addProduct(Admin product) throws AdminExceptions {
        try {
            return this.adminRepository.save(product);
        }
        catch (Exception e)
        {
            throw new AdminExceptions("Can't create the product: "+e.getMessage());
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
        }
        catch (Exception e)
        {
            throw new AdminExceptions("Can't retrieve the product by Id: "+e.getMessage());
        }
    }
    @Override
    public Product deleteProductById(Integer Id) throws AdminExceptions {
        try
        {
            return this.productRepository.findById(Id).get();
        }
        catch (Exception e)
        {
            throw new AdminExceptions("Can't delete the product by id: "+e.getMessage());
        }
    }


    //    @Override
//    public Product deleteProductById(Integer id) {
//        Optional<Product> accountOpt = this.productRepository.findById(id);
//        this.productRepository.deleteById(id);
//        return accountOpt.get();
//    }
    @Override
    public List<Product> getAllProducts() throws AdminExceptions{
        try {
            return this.productRepository.findAll();
        }
        catch (Exception e)
        {
            throw new AdminExceptions("Can't retrieve all products: "+e.getMessage());
        }
    }
    @Override
    public List<Customer> getAllCustomers() throws AdminExceptions {
        try {
            return this.customerRepository.findAll();
        }
        catch (Exception e)
        {
            throw new AdminExceptions("Can't retrieve all customers: "+e.getMessage());
        }
    }
    @Override
    public List<Product> findAllProductsContainingName(String queryName) throws AdminExceptions{
        try {
            return this.productRepository.findAll();
        }
        catch (Exception e)
        {
            throw new AdminExceptions("Can't retrieve the product name: "+e.getMessage());
        }
    }
}