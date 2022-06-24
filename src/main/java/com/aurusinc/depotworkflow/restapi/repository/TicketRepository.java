package com.aurusinc.depotworkflow.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurusinc.depotworkflow.restapi.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String>{

}