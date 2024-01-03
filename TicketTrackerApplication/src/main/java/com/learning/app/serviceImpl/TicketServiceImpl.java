package com.learning.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.app.dao.TicketDao;
import com.learning.app.entities.Ticket;
import com.learning.app.services.TicketService;

/**
 * This class provides service operations for the Ticket entity.
 */
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao ticketDao;

	/**
	 * Saves or updates a Ticket object.
	 *
	 * @param ticket The Ticket object to be saved or updated.
	 */
	@Transactional
	public void saveOrUpdateTicket(Ticket ticket) {
		ticketDao.save(ticket);
	}

	/**
	 * Deletes a ticket by its ID.
	 *
	 * @param ticketId The ID of the ticket to be deleted.
	 */
	@Transactional
	public void deleteTicket(Long ticketId) {
		Ticket ticket = ticketDao.getTicketById(ticketId);
		if (ticket != null) {
			ticketDao.deleteTicket(ticket);
		} else {
			throw new IllegalArgumentException("Ticket not found with ID: " + ticketId);
		}
	}

	/**
	 * Retrieves a list of all tickets.
	 *
	 * @return A list of all tickets.
	 */
	public List<Ticket> getAllTickets() {
		return ticketDao.getAllTickets();
	}

	/**
	 * Retrieves a ticket by its ID.
	 *
	 * @param ticketId The ID of the ticket to retrieve.
	 * @return The Ticket object with the specified ID.
	 */
	public Ticket getTicketById(Long ticketId) {
		return ticketDao.getTicketById(ticketId);
	}

	/**
	 * Updates a ticket.
	 *
	 * @param ticketId     The ID of the ticket to update.
	 * @param ticket The updated Ticket object.
	 */
	@Transactional
	public void updateTicket(Long ticketId, Ticket ticket) {
		Ticket existingTicket = ticketDao.getTicketById(ticketId);
		if (existingTicket != null) {
			ticket.setId(ticketId);
			ticketDao.save(ticket);
		} else {
			throw new IllegalArgumentException("Ticket not found with ID: " + ticketId);
		}
	}

	/**
	 * Retrieves a list of searched tickets based on a query.
	 *
	 * @param query The search query.
	 * @return A list of searched tickets.
	 */
	@Transactional
	public List<Ticket> getAllSearchedTickets(String query) {
		return ticketDao.getAllSearchedTickets(query);
	}
}