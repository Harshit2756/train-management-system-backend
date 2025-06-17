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
import com.tcs.booking.model.Booking;
import com.tcs.booking.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @PostMapping
  public ResponseEntity<Booking> createBooking(
    @RequestBody BookingRequestDTO dto
  ) {
    return ResponseEntity.ok(bookingService.createBooking(dto));
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
