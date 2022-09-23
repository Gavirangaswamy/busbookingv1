package com.dxctechproject.busticketbooking.Service;

import java.util.List;

import com.dxctechproject.busticketbooking.Entity.Cancelled;

public interface CancelledService{
	
	Cancelled cancelTicket(Cancelled ticket);
	
	List<Cancelled> getCancelledTickets();
	
	List<Cancelled> findByEmail(String email);
	
}
