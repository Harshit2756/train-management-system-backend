package com.tcs.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcs.booking.model.Seat;
import com.tcs.booking.model.SeatClass;
import com.tcs.booking.model.SeatStatus;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByBookingId(Long bookingId);

    // Fetch all seats for a train, class, and date (using Booking join)
    @Query("SELECT s FROM Seat s JOIN Booking b ON s.bookingId = b.bookingId WHERE b.trainId = :trainId AND b.travelDate = :travelDate AND s.seatClass = :seatClass AND s.status = :status")
    List<Seat> findByTrainIdAndSeatClassAndStatusAndTravelDate(
            @Param("trainId") Long trainId,
            @Param("seatClass") SeatClass seatClass,
            @Param("status") SeatStatus status,
            @Param("travelDate") java.time.LocalDate travelDate
    );

    // Fetch all seats for a train and date (using Booking join)
    @Query("SELECT s FROM Seat s JOIN Booking b ON s.bookingId = b.bookingId WHERE b.trainId = :trainId AND b.travelDate = :travelDate")
    List<Seat> findByTrainIdAndTravelDate(
            @Param("trainId") Long trainId,
            @Param("travelDate") java.time.LocalDate travelDate
    );

    // Fetch booked seat numbers for a train and date
    @Query("SELECT s.seatNumber FROM Seat s JOIN Booking b ON s.bookingId = b.bookingId WHERE b.trainId = :trainId AND b.travelDate = :travelDate AND s.status = 'CONFIRMED'")
    List<String> findBookedSeatNumbers(
            @Param("trainId") Long trainId,
            @Param("travelDate") java.time.LocalDate travelDate
    );
}
