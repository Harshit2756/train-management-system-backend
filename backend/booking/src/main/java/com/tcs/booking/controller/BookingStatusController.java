package com.tcs.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.booking.dto.ApiResponse;
import com.tcs.booking.model.Booking;
import com.tcs.booking.service.BookingService;

@RestController
@RequestMapping("/api/booking") 
public class BookingStatusController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/booking_status/{pnr}")
    public ResponseEntity<ApiResponse<String>> getBookingStatus(@PathVariable String pnr) {
        Booking booking = bookingService.getBookingByPnr(pnr);
        return ResponseEntity.ok(ApiResponse.success(booking.getStatus().name()));
    }
}
