package com.dxctechproject.busticketbooking.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechproject.busticketbooking.Entity.Ticket;
import com.dxctechproject.busticketbooking.Repository.TicketRepository;
import com.dxctechproject.busticketbooking.Service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {


    @Autowired
    private TicketRepository ticketRepository;

	@Override
	public Ticket save(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket findById(String id) {
		return ticketRepository.getById(id);
	}

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket findByRouteid(long id) {
		return ticketRepository.findByRouteid(id);
	}

	@Override
	public void deleteTicketById(String id) {
		// TODO Auto-generated method stub
		ticketRepository.delete(ticketRepository.getById(id));
	}

	@Override
	public List<Ticket> findByEmail(String email) {
		// TODO Auto-generated method stub
		return ticketRepository.findByUser(email);
	}
	
	
}
