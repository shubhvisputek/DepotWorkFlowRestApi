package com.aurusinc.depotworkflow.restapi.service;

import java.util.List;

import com.aurusinc.depotworkflow.restapi.model.Ticket;

public interface TicketService {
	Ticket saveTicket(Ticket ticket);
	List<Ticket> getAllTickets();
	Ticket getTicketById(String id);
	List<Ticket> getTicketByObject(Ticket ticket);
	Ticket updateTicket(Ticket ticket, String id);
	void deleteTicket(String id);
}
