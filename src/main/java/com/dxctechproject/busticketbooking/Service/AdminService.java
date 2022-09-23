package com.dxctechproject.busticketbooking.Service;

import com.dxctechproject.busticketbooking.Entity.Admin;

public interface AdminService {

    Admin findByEmailAndPassword(String email, String password);

    Admin save(Admin admin);

}