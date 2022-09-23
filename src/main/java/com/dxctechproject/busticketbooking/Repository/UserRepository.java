package com.dxctechproject.busticketbooking.Repository;

import com.dxctechproject.busticketbooking.Entity.User;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);
    
    User findByEmail(String email);
    
    @Modifying
	@Transactional
	@Query("update User user set user.password = :password WHERE user.email = :email")
    void updatePassword(@Param(value = "password") String password, @Param("email") String email);

}