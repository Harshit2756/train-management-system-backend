package com.tcs.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.booking.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByBookingId(Long bookingId);
    List<Seat> findByTrainIdAndTravelDate(Long trainId, java.time.LocalDate travelDate);
} 