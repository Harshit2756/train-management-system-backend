package com.tcs.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.booking.dto.BookingRequestDTO;
import com.tcs.booking.dto.BookingResponseDTO;
import com.tcs.booking.model.Booking;
import com.tcs.booking.model.Seat;
import com.tcs.booking.model.Ticket;
import com.tcs.booking.repository.SeatRepository;
import com.tcs.booking.service.BookingService;
import com.tcs.booking.service.TicketService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @Autowired
  private SeatRepository seatRepository;

  @Autowired
  private TicketService ticketService;

  @PostMapping
  public ResponseEntity<BookingResponseDTO> createBooking(
    @RequestBody BookingRequestDTO dto
  ) {
    Booking booking = bookingService.createBooking(dto);
    // Fetch seats and tickets for the booking
    java.util.List<Seat> seats = seatRepository.findByBookingId(
      booking.getBookingId()
    );
    java.util.List<Ticket> tickets = ticketService.getTicketsByBookingId(
      booking.getBookingId()
    );
    BookingResponseDTO response = new BookingResponseDTO(
      booking,
      seats,
      tickets
    );
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{bookingId}")
  public ResponseEntity<Booking> getBooking(@PathVariable Long bookingId) {
    return ResponseEntity.ok(bookingService.getBooking(bookingId));
  }

  @PutMapping("/{bookingId}/cancel")
  public ResponseEntity<Booking> cancelBooking(@PathVariable Long bookingId) {
    return ResponseEntity.ok(bookingService.cancelBooking(bookingId));
  }
}
