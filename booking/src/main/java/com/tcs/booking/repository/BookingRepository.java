package com.tcs.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByPnr(String pnr);
} 