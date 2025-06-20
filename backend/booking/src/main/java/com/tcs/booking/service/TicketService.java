package com.tcs.booking.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.booking.exception.TicketNotFoundException;
import com.tcs.booking.model.Ticket;
import com.tcs.booking.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket getTicket(Long ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException("Ticket not found with id: " + ticketId));
    }

    public List<Ticket> generateTickets(
            Long bookingId,
            List<Long> passengerIds,
            LocalDate travelDate
    ) {
        List<Ticket> tickets = new ArrayList<>();
        for (Long passengerId : passengerIds) {
            Ticket ticket = new Ticket();
            ticket.setBookingId(bookingId);
            ticket.setPassengerId(passengerId);
            ticket.setStartDate(travelDate);
            ticket.setEndDate(travelDate);
            ticket.setStatus(com.tcs.booking.model.TicketStatus.ACTIVE);
            ticket.setCreatedAt(LocalDateTime.now());
            tickets.add(ticketRepository.save(ticket));
        }
        return tickets;
    }

    public List<Ticket> getTicketsByBookingId(Long bookingId) {
        return ticketRepository.findByBookingId(bookingId);
    }
}
