package com.tcs.booking.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seatId;

  @Column(nullable = false)
  private Long bookingId;

  @Column(nullable = false)
  private Long passengerId;

  @Column(nullable = false)
  private String seatNumber;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SeatType seatType;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SeatClass seatClass;

  @Column(nullable = false)
  private BigDecimal fare;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SeatStatus status = SeatStatus.CONFIRMED;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  public Seat() {
    super();
  }

  public Long getSeatId() {
    return seatId;
  }

  public void setSeatId(Long seatId) {
    this.seatId = seatId;
  }

  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public Long getPassengerId() {
    return passengerId;
  }

  public void setPassengerId(Long passengerId) {
    this.passengerId = passengerId;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }

  public SeatType getSeatType() {
    return seatType;
  }

  public void setSeatType(SeatType seatType) {
    this.seatType = seatType;
  }

  public SeatClass getSeatClass() {
    return seatClass;
  }

  public void setSeatClass(SeatClass seatClass) {
    this.seatClass = seatClass;
  }

  public BigDecimal getFare() {
    return fare;
  }

  public void setFare(BigDecimal fare) {
    this.fare = fare;
  }

  public SeatStatus getStatus() {
    return status;
  }

  public void setStatus(SeatStatus status) {
    this.status = status;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

   
}
