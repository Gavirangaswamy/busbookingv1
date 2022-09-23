package com.dxctechproject.busticketbooking.Repository;

import com.dxctechproject.busticketbooking.Entity.Ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {
	
	public Ticket findByRouteid(long id);
	
	List<Ticket> findByUser(String user);
	
}