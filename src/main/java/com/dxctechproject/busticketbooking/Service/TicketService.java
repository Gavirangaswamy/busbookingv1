package com.dxctechproject.busticketbooking.Service;

import java.util.List;

import com.dxctechproject.busticketbooking.Entity.Ticket;

public interface TicketService {

	Ticket save(Ticket ticket);
	
	Ticket findById(String id);
	
	List<Ticket> findAll();
	
	Ticket findByRouteid(long id);
	
	void deleteTicketById(String id);
	
	List<Ticket> findByEmail(String email);
}
