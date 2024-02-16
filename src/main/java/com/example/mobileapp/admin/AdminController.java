package com.example.mobileapp.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
   private AdminService adminService;
    @PostMapping("admin")
    public Admin createAccount(@RequestBody Admin addProducts) {
        return this.adminService.addProduct(addProducts);

    }
}
