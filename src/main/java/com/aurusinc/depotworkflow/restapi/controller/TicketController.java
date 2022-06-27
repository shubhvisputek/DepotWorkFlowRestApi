package com.aurusinc.depotworkflow.restapi.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurusinc.depotworkflow.restapi.exception.ResourceNotFoundException;
import com.aurusinc.depotworkflow.restapi.model.Device;
import com.aurusinc.depotworkflow.restapi.model.Ticket;
import com.aurusinc.depotworkflow.restapi.service.TicketService;
import com.aurusinc.depotworkflow.restapi.util.DeviceUtility;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

	Logger logger = LoggerFactory.getLogger(TicketController.class);
	
	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}
	
	// build create ticket REST API
	@PostMapping
	public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) throws ResourceNotFoundException{

		if(ticket.getDevices() != null){
			for (int i=0; i<ticket.getDevices().size(); i++) {
				Device device = ticket.getDevices().get(i);
				if(device.getDummyTID() == null || device.getDummyTID().isEmpty()){
					device.setDummyTID(DeviceUtility.getDeviceUtility().getDummyTID());
				}
			}
		}
		return new ResponseEntity<Ticket>(ticketService.saveTicket(ticket), HttpStatus.OK);
	}

	// build get all tickets REST API
	// @GetMapping
	// public ResponseEntity<List<Ticket>> getAllTickets(){
	// 	return new ResponseEntity<List<Ticket>>(ticketService.getAllTickets(), HttpStatus.OK);
	// }
	
	// build get ticket by id REST API
	// http://localhost:8080/api/tickets/1
	@GetMapping(path = {"", "{id}"})
	public ResponseEntity getTicketById(@RequestParam(required=true) Map<String, String> qParamsMap, Ticket ticket) throws ResourceNotFoundException{
		if(qParamsMap != null && qParamsMap.size() != 0){

			// List<Ticket> tickets = ticketService.getTicketByObject(ticket);

			// if(tickets.size()==1){
			// 	return new ResponseEntity<Ticket>(tickets.get(0), HttpStatus.OK);
			// }
			// else{
			// 	return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
			// }

			//ResponseEntity.ok().body(employee);

			return new ResponseEntity<List<Ticket>>(ticketService.getTicketByObject(ticket), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Ticket>>(ticketService.getAllTickets(), HttpStatus.OK);
		}
	}
	
	// build update ticket REST API
	// http://localhost:8080/api/tickets/1
	@PutMapping("{id}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable("id") String id ,@RequestBody Ticket ticket) throws ResourceNotFoundException{

		if(ticket.getDevices() != null){
			for (int i=0; i<ticket.getDevices().size(); i++) {
				Device device = ticket.getDevices().get(i);
				if(device.getDummyTID() == null || device.getDummyTID().isEmpty()){
					device.setDummyTID(DeviceUtility.getDeviceUtility().getDummyTID());
				}
			}
		}

		return new ResponseEntity<Ticket>(ticketService.updateTicket(ticket, id), HttpStatus.OK);
	}
	
	// build delete ticket REST API
	// http://localhost:8080/api/tickets/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTicket(@PathVariable("id") String id) throws ResourceNotFoundException{
		
		// delete ticket from DB
		ticketService.deleteTicket(id);
		
		return new ResponseEntity<String>("Ticket deleted successfully!.", HttpStatus.OK);
	}
	
}
