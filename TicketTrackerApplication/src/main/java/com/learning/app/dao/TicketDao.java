package com.learning.app.dao;

import java.util.List;

import com.learning.app.entities.Ticket;

public interface TicketDao {

	public void save(Ticket ticket);

	public List<Ticket> getAllTickets();

	public List<Ticket> getAllSearchedTickets(String query);

	public void deleteTicket(Ticket ticket);

	public Ticket getTicketById(Long ticketId);
}
