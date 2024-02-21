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
    public Product addProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Admin updateProduct(Admin account) {
        return this.adminRepository.save(account);
    }
    @Override
    public Product getProductById(Integer Id) {
        return this.productRepository.findById(Id).get();
    }
    @Override
    public Product deleteProductById(Integer id) {
        Optional<Product> accountOpt = this.productRepository.findById(id);
        // exception handling
        this.productRepository.deleteById(id);
        return accountOpt.get();
    }
//    @Override
//    public Admin deleteProductById(Integer id) {
//        Optional<Admin> accountOpt = this.adminRepository.findById(id);
//        // exception handling
//        this.adminRepository.deleteById(id);
//        return accountOpt.get();
//    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public List<Product> findAllProductsContainingName(String queryName) {
        //return this.productRepository.findById();
        return this.productRepository.findAll();
    }
}

//    @Override
//    public Double fundDeposit(String fromAccountEmail, Double depositAmount)throws AccountExceptions {
//        Optional<Admin> accountOpt = this.adminRepository.findByEmail(fromAccountEmail);
//        if(accountOpt.isEmpty())
//            throw new AccountExceptions("Account does not exists: "+fromAccountEmail);
//
//        Admin foundAccount  = accountOpt.get();
//        foundAccount.setAmount(foundAccount.getAmount()+depositAmount);
//
//        this.adminRepository.save(foundAccount);
//        return foundAccount.getAmount();
//    }
//    @Override
//    public Admin addProduct(Admin addProducts) {
//        return this.adminRepository.save(addProducts);
//    }
//    @Override
//   public Optional<Product> getProductById(Integer id) {
//       return Optional.empty();
//    }
//
//    @Override
//   public Admin updateProduct(Admin updateProducts) {
//       return this.adminRepository.save(updateProducts);
//    }
//    @Override
//    public Admin deleteProduct(Admin deleteProducts) {
//        return null;
//    }