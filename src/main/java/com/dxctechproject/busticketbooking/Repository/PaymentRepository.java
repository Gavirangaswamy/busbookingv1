package com.dxctechproject.busticketbooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctechproject.busticketbooking.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

}
