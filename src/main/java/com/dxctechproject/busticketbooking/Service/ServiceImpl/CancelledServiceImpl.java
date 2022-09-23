package com.dxctechproject.busticketbooking.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechproject.busticketbooking.Entity.Cancelled;
import com.dxctechproject.busticketbooking.Repository.CancelledRepository;
import com.dxctechproject.busticketbooking.Service.CancelledService;

@Service
public class CancelledServiceImpl implements CancelledService{
	
	@Autowired
	private CancelledRepository service;
	
	public Cancelled cancelTicket(Cancelled ticket) {
		Cancelled cancelled = service.save(ticket);
		return cancelled;
	}
	
	public List<Cancelled> getCancelledTickets() {
		return service.findAll();
	}

	@Override
	public List<Cancelled> findByEmail(String email) {
		// TODO Auto-generated method stub
		return service.findByUser(email);
	}
	
}
