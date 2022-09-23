package com.dxctechproject.busticketbooking.Service.ServiceImpl;

import com.dxctechproject.busticketbooking.Entity.Admin;
import com.dxctechproject.busticketbooking.Repository.AdminRepository;
import com.dxctechproject.busticketbooking.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin findByEmailAndPassword(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }
}
