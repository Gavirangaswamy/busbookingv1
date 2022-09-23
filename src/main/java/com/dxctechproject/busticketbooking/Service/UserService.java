package com.dxctechproject.busticketbooking.Service;

import java.util.List;

import com.dxctechproject.busticketbooking.Entity.User;

public interface UserService {

    User save(User user);

    User findByEmailAndPassword(String email, String password);
    
    List<User> getAllUsers();
    
    User findByEmail(String email);
    
    void upadatePassword(String password, String email);
}
