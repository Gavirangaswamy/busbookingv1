package com.dxctechproject.busticketbooking.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechproject.busticketbooking.Entity.Payment;
import com.dxctechproject.busticketbooking.Repository.PaymentRepository;
import com.dxctechproject.busticketbooking.Service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentrep;
	@Override
	public Payment saveDetails(Payment payment) {
		// TODO Auto-generated method stub
		Payment pay = paymentrep.save(payment);
		return pay;
	}

}
