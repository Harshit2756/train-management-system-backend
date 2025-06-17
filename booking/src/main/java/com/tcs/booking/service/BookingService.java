package com.tcs.booking.service;

import com.tcs.booking.dto.BookingRequestDTO;
import com.tcs.booking.exception.BookingNotFoundException;
import com.tcs.booking.model.Booking;
import com.tcs.booking.model.BookingStatus;
import com.tcs.booking.repository.BookingRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;

  public Booking createBooking(BookingRequestDTO dto) {
    Booking booking = new Booking();
    booking.setPnr("PNR" + System.currentTimeMillis());
    booking.setCustomerId(dto.getCustomerId());
    booking.setTrainId(dto.getTrainId());
    booking.setFromStationId(dto.getFromStationId());
    booking.setToStationId(dto.getToStationId());
    booking.setTravelDate(dto.getTravelDate());
    booking.setDepartureTime(dto.getDepartureTime());
    booking.setArrivalTime(dto.getArrivalTime());
    booking.setTotalPassengers(dto.getTotalPassengers());
    booking.setTotalAmount(dto.getTotalAmount());
    booking.setStatus(BookingStatus.CONFIRMED);
    booking.setBookingDate(LocalDateTime.now());
    booking.setCreatedAt(LocalDateTime.now());
    return bookingRepository.save(booking);
  }

  public Booking getBooking(Long bookingId) {
    return bookingRepository
      .findById(bookingId)
      .orElseThrow(() ->
        new BookingNotFoundException("Booking not found with id: " + bookingId)
      );
  }

  public Booking cancelBooking(Long bookingId) {
    Booking booking = bookingRepository
      .findById(bookingId)
      .orElseThrow(() ->
        new BookingNotFoundException("Booking not found with id: " + bookingId)
      );
    booking.setStatus(BookingStatus.CANCELLED);
    return bookingRepository.save(booking);
  }
}
