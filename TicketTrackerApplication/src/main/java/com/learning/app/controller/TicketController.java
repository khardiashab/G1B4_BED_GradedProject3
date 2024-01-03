/**
 * TicketController.java is a Java file that contains the definition of a controller class for managing tickets in an application.
 * It implements various methods for handling different HTTP requests related to tickets, such as creating, updating, deleting, and searching tickets.
 * The controller is annotated with the @Controller annotation from the Spring Framework, indicating that it is a component responsible for handling HTTP requests.
 * The class also includes several mapping annotations, such as @GetMapping and @PostMapping, which specify the URL paths for accessing the corresponding methods.
 * The controller interacts with the Ticket entity class and uses the Model and ModelMap classes for handling data and rendering views.
 */
package com.learning.app.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.learning.app.entities.Ticket;

public interface TicketController {

    public String getHomePage(ModelMap model);

    public String getAddTicketPage(Model model);

    public String saveAndUpdateTicket(Ticket ticket, Model model);

    public String viewTicket(Long id, Model model);

    public String getUpdateTicketPage(Model model, Long id);

    public String updateTicket(Ticket ticket, Long id, Model model);

    public String deleteTicket(Long ticketId, Model model);

    public String getSearchedTicket(String query, Model model);
}