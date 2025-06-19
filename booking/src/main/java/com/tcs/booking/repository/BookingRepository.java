package com.tcs.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Booking findByPnr(String pnr);

    // Find all bookings for a train on a specific date
    List<Booking> findByTrainIdAndTravelDate(Long trainId, java.time.LocalDate travelDate);

    // Find all bookings for a customer
    List<Booking> findByCustomerId(Long customerId);
}
