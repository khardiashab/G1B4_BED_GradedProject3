package com.learning.app.controllerImpl;

import java.time.LocalDate;

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

import com.learning.app.controller.TicketController;
import com.learning.app.entities.Ticket;
import com.learning.app.services.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketControllerImpl implements TicketController {

    @Autowired
    private TicketService ticketService;

    /**
     * Get the Home-page with all tickets.
     * 
     * @param model the ModelMap object to add attributes
     * @return the name of the view template for the home-page
     */
    @GetMapping()
    public String getHomePage(ModelMap model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "home-page";
    }

    /**
     * Get the form for adding a new ticket.
     * 
     * @param model the Model object to add attributes
     * @return the name of the view template for the add ticket page
     */
    @GetMapping("/newTicket")
    public String getAddTicketPage(Model model) {
        model.addAttribute("formHeading", "Create a New Ticket");
        Ticket ticket = new Ticket();
        model.addAttribute("ticket", ticket);
        return "create-ticket-page";
    }

    /**
     * Save or update a ticket.
     * 
     * @param ticket the Ticket object to save or update
     * @param model  the Model object to add attributes
     * @return the name of the view template for the homepage
     */
    @PostMapping("/newTicket")
    public String saveAndUpdateTicket(@ModelAttribute("ticket") Ticket ticket, Model model) {
        if (ticket.getId() == null) {
            ticket.setCreatedOn(LocalDate.now());
        }
        ticketService.saveOrUpdateTicket(ticket);
        return "redirect:/tickets";
    }

    /**
     * View details of a ticket.
     * 
     * @param id    the ID of the ticket to view
     * @param model the Model object to add attributes
     * @return the name of the view template for the view ticket page
     */
    @GetMapping("/{id}")
    public String viewTicket(@PathVariable("id") Long ticketId, Model model) {
        model.addAttribute("ticket", ticketService.getTicketById(ticketId));
        return "view-ticket";
    }

    /**
     * Get the form for updating a ticket.
     * 
     * @param model the Model object to add attributes
     * @param id    the ID of the ticket to update
     * @return the name of the view template for the update ticket page
     */
    @GetMapping("/{id}/edit")
    public String getUpdateTicketPage(Model model, @PathVariable("id") Long ticketId) {
        model.addAttribute("formHeading", "Edit a Ticket");
        model.addAttribute("ticket", ticketService.getTicketById(ticketId));
        return "create-ticket-page";
    }

    /**
     * Update a ticket.
     * 
     * @param ticket the updated Ticket object
     * @param id     the ID of the ticket to update
     * @param model  the Model object to add attributes
     * @return the name of the view template for the homepage
     */
    @PostMapping("/{id}/edit")
    public String updateTicket(@ModelAttribute("ticket") Ticket ticket, @PathVariable("id") Long id, Model model) {
        ticketService.updateTicket(id, ticket);
        return "redirect:/tickets";
    }

    /**
     * Delete a ticket.
     * 
     * @param ticketId the ID of the ticket to delete
     * @param model    the Model object to add attributes
     * @return the name of the view template for the homepage
     */
    @GetMapping("/{id}/delete")
    public String deleteTicket(@PathVariable("id") Long ticketId, Model model) {
        ticketService.deleteTicket(ticketId);
        return "redirect:/tickets";
    }

    /**
     * Search for tickets based on a query.
     * 
     * @param query the search query
     * @param model the Model object to add attributes
     * @return the name of the view template for the homepage
     */
    @GetMapping("/search")
    public String getSearchedTicket(@RequestParam("query") String query, Model model) {
        if (!query.isEmpty()) {
            model.addAttribute("tickets", ticketService.getAllSearchedTickets(query));
        }
        return "home-page";
    }
}