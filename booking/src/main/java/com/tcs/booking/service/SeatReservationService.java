package com.tcs.booking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.booking.model.Seat;
import com.tcs.booking.repository.SeatRepository;

@Service
public class SeatReservationService {

  @Autowired
  private SeatRepository seatRepository;

  public List<Seat> getAvailableSeats(Long trainId, LocalDate travelDate) {
    // Dummy: return all seats for the train and date
    return seatRepository.findByTrainIdAndTravelDate(trainId, travelDate);
  }

  public List<Seat> reserveSeats(List<Seat> seats) {
    // Dummy: just save all seats
    return seatRepository.saveAll(seats);
  }
}
