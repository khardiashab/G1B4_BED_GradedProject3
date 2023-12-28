package com.learning.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.app.entities.Ticket;
import com.learning.app.services.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping()
	public String homepage(ModelMap model) {
		try {
			model.addAttribute("tickets", ticketService.getAllTickets());
			return "homescreen";
		} catch (Exception e) {
			model.addAttribute("error", e.getLocalizedMessage());
			return "error-page";
		}
	}

	/**
	 * Display the form for adding a new ticket.
	 */
	@GetMapping("/newTicket")
	public String getAddTicketPage(Model model) {
		try {
			model.addAttribute("formHeading", "Create a New Ticket");
			Ticket ticket = new Ticket();
			model.addAttribute("ticket", ticket);
			return "create-ticket-page";
		} catch (Exception e) {
			model.addAttribute("error", e.getLocalizedMessage());
			return "error-page";
		}
	}

	@PostMapping("/newTicket")
	public String saveAndUpdateTicket(@ModelAttribute("ticket") Ticket ticket, Model model) {
		try {
			if (ticket.getId() == null) {
				ticket.setCreatedOn(new Date());
			}
			ticketService.saveOrUpdateTicket(ticket);
			return "redirect:/tickets";
		} catch (Exception e) {
			model.addAttribute("error", e.getLocalizedMessage());
			return "error-page";
		}
	}

	/**
	 * View details of a ticket.
	 */
	@GetMapping("/{id}")
	public String viewTicket(@PathVariable("id") Long id, Model model) {
		try {
			model.addAttribute("formHeading", "Ticket");
			model.addAttribute("ticket", ticketService.getTicketById(id));
			return "create-ticket-page";
		} catch (Exception e) {
			model.addAttribute("error", e.getLocalizedMessage());
			return "error-page";
		}
	}

	/**
	 * Display the form for updating a ticket.
	 */
	@GetMapping("/{id}/edit")
	public String getUpdateTicketPage(Model model, @PathVariable("id") Long id) {
		try {
			model.addAttribute("formHeading", "Edit a Ticket");
			model.addAttribute("ticket", ticketService.getTicketById(id));
			return "create-ticket-page";
		} catch (Exception e) {
			model.addAttribute("error", e.getLocalizedMessage());
			return "error-page";
		}
	}

	/**
	 * Update a ticket.
	 */
	@PostMapping("/{id}/edit")
	public String updateTicket(@ModelAttribute("ticket") Ticket ticket, @PathVariable("id") Long id, Model model) {
		try {
			ticketService.updateTicket(id, ticket);
			return "redirect:/tickets";
		} catch (Exception e) {
			model.addAttribute("error", e.getLocalizedMessage());
			return "error-page";
		}
	}

	/**
	 * Delete a ticket.
	 */
	@GetMapping("/{id}/delete")
	public String deleteTicket(@PathVariable("id") Long ticketId, Model model) {
		try {
			ticketService.deleteTicket(ticketId);
			return "redirect:/tickets";
		} catch (Exception e) {
			model.addAttribute("error", e.getLocalizedMessage());
			return "error-page";
		}
	}

	/**
	 * Search for tickets based on a query.
	 */
	@GetMapping("/search")
	public String getSearchedTicket(@RequestParam("query") String query, Model model) {
		try {
			if (!query.isEmpty()) {
				model.addAttribute("tickets", ticketService.getAllSearchedTickets(query));
			}
			return "homescreen";
		} catch (Exception e) {
			model.addAttribute("error", e.getLocalizedMessage());
			return "error-page";
		}
	}
}