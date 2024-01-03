package com.learning.app.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.learning.app.dao.TicketDao;
import com.learning.app.entities.Ticket;

/**
 * This class provides data access operations for the Ticket entity.
 */
@Repository
public class TicketDaoImpl implements TicketDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * Saves a Ticket object to the database.
	 *
	 * @param ticket The Ticket object to be saved.
	 * @throws RuntimeException If there is an error saving the ticket.
	 */
	public void save(Ticket ticket) {
		try {
			hibernateTemplate.saveOrUpdate(ticket);
		} catch (DataAccessException dataAccessException) {
			String errorMessage = "DataAccessException occurred while saving the ticket. \nLocation: save method. \nCause: "
					+ dataAccessException.getMessage();
			throw new RuntimeException(errorMessage, dataAccessException);
		} catch (Exception e) {
			String errorMessage = "Exception occurred while saving the ticket. \nLocation: save method. \nCause: "
					+ e.getMessage();
			throw new RuntimeException(errorMessage, e);
		}
	}

	/**
	 * Retrieves a list of all tickets from the database.
	 *
	 * @return A list of all tickets.
	 * @throws RuntimeException If there is an error retrieving the tickets.
	 */
	public List<Ticket> getAllTickets() {
		try {
			return hibernateTemplate.loadAll(Ticket.class);
		} catch (DataAccessException dataAccessException) {
			String errorMessage = "DataAccessException occurred while retrieving the tickets. \nLocation: getAllTickets method. \nCause: "
					+ dataAccessException.getMessage();
			throw new RuntimeException(errorMessage, dataAccessException);
		} catch (Exception e) {
			String errorMessage = "Exception occurred while retrieving the tickets. \nLocation: getAllTickets method. \nCause: "
					+ e.getMessage();
			throw new RuntimeException(errorMessage, e);
		}
	}

	/**
	 * Deletes a ticket from the database.
	 *
	 * @param ticket The Ticket object to be deleted.
	 * @throws RuntimeException If there is an error deleting the ticket.
	 */
	public void deleteTicket(Ticket ticket) {
		try {
			hibernateTemplate.delete(ticket);
		} catch (DataAccessException dataAccessException) {
			String errorMessage = "DataAccessException occurred while deleting the ticket. \nLocation: deleteTicket method. \nCause: "
					+ dataAccessException.getMessage();
			throw new RuntimeException(errorMessage, dataAccessException);
		} catch (Exception e) {
			String errorMessage = "Exception occurred while deleting the ticket. \nLocation: deleteTicket method. \nCause: "
					+ e.getMessage();
			throw new RuntimeException(errorMessage, e);
		}
	}

	/**
	 * Retrieves a ticket from the database based on its ID.
	 *
	 * @param ticketId The ID of the ticket to be retrieved.
	 * @return The Ticket object with the specified ID.
	 * @throws IllegalArgumentException If the ticket is not found.
	 * @throws RuntimeException         If there is an error retrieving the ticket.
	 */
	public Ticket getTicketById(Long ticketId) {
		try {
			Ticket ticket = hibernateTemplate.get(Ticket.class, ticketId);
			if (ticket != null) {
				return ticket;
			}
			throw new IllegalArgumentException("This ticket is not valid");
		} catch (DataAccessException dataAccessException) {
			String errorMessage = "DataAccessException occurred while retrieving the ticket. \nLocation: getTicketById method. \nCause: "
					+ dataAccessException.getMessage();
			throw new RuntimeException(errorMessage, dataAccessException);
		} catch (Exception e) {
			String errorMessage = "Exception occurred while retrieving the ticket. \nLocation: getTicketById method. \nCause: "
					+ e.getMessage();
			throw new RuntimeException(errorMessage, e);
		}
	}

	/**
	 * Retrieves a list of all searched tickets from the database based on a query.
	 *
	 * @param query The search query.
	 * @return A list of searched tickets.
	 * @throws RuntimeException If there is an error retrieving the searched
	 *                          tickets.
	 */
	public List<Ticket> getAllSearchedTickets(String query) {
		try {
			String sql = "SELECT * FROM ticket WHERE title LIKE :query OR short_description LIKE :query";
			SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.getCurrentSession();
				@SuppressWarnings("unchecked")
				List<Ticket> list = (List<Ticket>) session.createSQLQuery(sql).setParameter("query", "%" + query + "%")
						.addEntity(Ticket.class).list();
				return list;
			} else {
				throw new RuntimeException("SessionFactory is null");
			}
		} catch (HibernateException hibernateException) {
			String errorMessage = "HibernateException occurred while retrieving the searched tickets. \nLocation: getAllSearchedTickets method. \nCause: "
					+ hibernateException.getMessage();
			throw new RuntimeException(errorMessage, hibernateException);
		} catch (Exception e) {
			String errorMessage = "Exception occurred while retrieving the searched tickets. \nLocation: getAllSearchedTickets method. \nCause: "
					+ e.getMessage();
			throw new RuntimeException(errorMessage, e);
		}
	}
}