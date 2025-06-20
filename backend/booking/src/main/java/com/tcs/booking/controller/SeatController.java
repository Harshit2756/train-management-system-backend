package com.tcs.booking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.booking.dto.ApiResponse;
import com.tcs.booking.model.Seat;
import com.tcs.booking.model.SeatClass;
import com.tcs.booking.service.SeatReservationService;

@RestController
@RequestMapping("/api/booking/seats")
public class SeatController {

    @Autowired
    private SeatReservationService seatReservationService;

    @GetMapping("/available")
    public ResponseEntity<ApiResponse<List<Seat>>> getAvailableSeats(
            @RequestParam Long trainId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate travelDate,
            @RequestParam SeatClass seatClass) {

        List<Seat> availableSeats = seatReservationService.getAvailableSeats(trainId, travelDate, seatClass);
        return ResponseEntity.ok(ApiResponse.success(availableSeats));
    }
}
