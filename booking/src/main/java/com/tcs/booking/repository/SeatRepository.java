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
  List<Seat> findByTrainIdAndTravelDate(
    Long trainId,
    java.time.LocalDate travelDate
  );
  List<Seat> findByTrainIdAndSeatClassAndStatus(
    Long trainId,
    SeatClass seatClass,
    SeatStatus status
  );

  @Query(
    "SELECT s.seatNumber FROM Seat s WHERE s.trainId = :trainId AND s.status = 'CONFIRMED' AND s.createdAt >= :travelDateStart AND s.createdAt < :travelDateEnd"
  )
  List<String> findBookedSeatNumbers(
    @Param("trainId") Long trainId,
    @Param("travelDateStart") java.time.LocalDateTime travelDateStart,
    @Param("travelDateEnd") java.time.LocalDateTime travelDateEnd
  );
}
