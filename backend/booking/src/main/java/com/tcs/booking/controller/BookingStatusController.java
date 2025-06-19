package com.tcs.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.booking.model.Booking;
import com.tcs.booking.repository.BookingRepository;

@RestController
@RequestMapping("/api")
public class BookingStatusController {

  @Autowired
  private BookingRepository bookingRepository;

  @GetMapping("/booking_status/{pnr}")
  public ResponseEntity<String> getBookingStatus(@PathVariable String pnr) {
    Booking booking = bookingRepository.findByPnr(pnr);
    return ResponseEntity.ok(
      booking != null ? booking.getStatus().name() : "NOT_FOUND"
    );
  }
}
