package com.example.mobileapp.admin;

import org.springframework.stereotype.Service;
@Service
public class AdminImplementation implements AdminService{
private AdminRepository adminRepository;
    @Override
    public Admin addProduct(Admin addProducts) {
        return this.adminRepository.save(addProducts);
    }
//
//    @Override
//    public Optional<admin> getProductById(Integer id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public admin updateProduct(admin updateProducts) {
//        return null;
//    }
//
//    @Override
//    public admin deleteProduct(admin deleteProducts) {
//        return null;
//    }
}
