package com.aurusinc.depotworkflow.restapi.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.aurusinc.depotworkflow.restapi.exception.ResourceNotFoundException;
import com.aurusinc.depotworkflow.restapi.model.Ticket;
import com.aurusinc.depotworkflow.restapi.repository.TicketRepository;
import com.aurusinc.depotworkflow.restapi.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	private TicketRepository ticketRepository;
	
	public TicketServiceImpl(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(String id) {
		return ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket")); 
		
	}

	@Override
	public List<Ticket> getTicketByObject(Ticket ticket) {
		return ticketRepository.findAll(Example.of(ticket)); 
	}

	@Override
	public Ticket updateTicket(Ticket ticket, String id) {
		
		// we need to check whether employee with given id is exist in DB or not
		Ticket existingTicket = ticketRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Ticket")); 
		
		if(ticket.getTicketID() != null) 			existingTicket.setTicketID(ticket.getTicketID());
        if(ticket.getTicketName() != null) 			existingTicket.setTicketName(ticket.getTicketName());
        if(ticket.getTicketDescription() != null) 	existingTicket.setTicketDescription(ticket.getTicketDescription());
        if(ticket.getTicketStatus() != null) 		existingTicket.setTicketStatus(ticket.getTicketStatus());
        if(ticket.getTicketPriority() != null) 		existingTicket.setTicketPriority(ticket.getTicketPriority());
		if(ticket.getDeviceType() != null) 			existingTicket.setDeviceType(ticket.getDeviceType());
        if(ticket.getPonumber() != null) 			existingTicket.setPonumber(ticket.getPonumber());
        if(ticket.getStorageBin() != null) 			existingTicket.setStorageBin(ticket.getStorageBin());
        if(ticket.getSbom() != null) 				existingTicket.setSbom(ticket.getSbom());
        if(ticket.getPartNumber() != null) 			existingTicket.setPartNumber(ticket.getPartNumber());
        if(ticket.getCorpID() != null) 				existingTicket.setCorpID(ticket.getCorpID());
        if(ticket.getCorpName() != null) 			existingTicket.setCorpName(ticket.getCorpName());
		if(ticket.getKeysInfo() != null) 			existingTicket.setKeysInfo(ticket.getKeysInfo());
		if(ticket.getDevices() != null) 			existingTicket.setDevices(ticket.getDevices());

		// save existing employee to DB
		ticketRepository.save(existingTicket);
		return existingTicket;
	}

	@Override
	public void deleteTicket(String id) {
		
		// check whether a employee exist in a DB or not
		ticketRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Ticket"));
                                ticketRepository.deleteById(id);
	}
	
}
