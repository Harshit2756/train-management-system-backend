package com.tcs.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.booking.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {}
