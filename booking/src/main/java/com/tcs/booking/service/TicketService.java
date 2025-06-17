package com.tcs.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.booking.model.Ticket;
import com.tcs.booking.repository.TicketRepository;

@Service
public class TicketService {

  @Autowired
  private TicketRepository ticketRepository;

  public Ticket getTicket(Long ticketId) {
    return ticketRepository.findById(ticketId).orElse(null);
  }
}
