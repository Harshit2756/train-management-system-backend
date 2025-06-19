package com.tcs.booking.dto;

import java.util.List;

import com.tcs.booking.model.Booking;
import com.tcs.booking.model.Seat;
import com.tcs.booking.model.Ticket;

public class BookingResponseDTO {

  private Booking booking;
  private List<Seat> seats;
  private List<Ticket> tickets;

  public BookingResponseDTO(
    Booking booking,
    List<Seat> seats,
    List<Ticket> tickets
  ) {
    this.booking = booking;
    this.seats = seats;
    this.tickets = tickets;
  }

  public Booking getBooking() {
    return booking;
  }

  public void setBooking(Booking booking) {
    this.booking = booking;
  }

  public List<Seat> getSeats() {
    return seats;
  }

  public void setSeats(List<Seat> seats) {
    this.seats = seats;
  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }
}
