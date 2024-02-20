package com.example.mobileapp.admin;

import org.springframework.stereotype.Service;
@Service
public class AdminImplementation implements AdminService{
private AdminRepository adminRepository;
    @Override
    public Admin addProduct(Admin addProducts) {
        return this.adminRepository.save(addProducts);
    }

}
