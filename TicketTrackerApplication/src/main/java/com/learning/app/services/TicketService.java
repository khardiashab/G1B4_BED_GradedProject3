package com.learning.app.services;

import java.util.List;

import com.learning.app.entities.Ticket;

public interface TicketService {

	public void saveOrUpdateTicket(Ticket ticket);

	public void updateTicket(Long id, Ticket ticket);

	public void deleteTicket(Long ticketId);

	public List<Ticket> getAllTickets();

	public List<Ticket> getAllSearchedTickets(String query);

	public Ticket getTicketById(Long ticketId);

}
