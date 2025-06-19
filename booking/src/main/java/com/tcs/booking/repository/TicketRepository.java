package com.tcs.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.booking.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
  List<Ticket> findByBookingId(Long bookingId);
}
