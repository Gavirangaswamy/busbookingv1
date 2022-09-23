package com.dxctechproject.busticketbooking.Repository;

import com.dxctechproject.busticketbooking.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmailAndPassword(String email, String password);
}