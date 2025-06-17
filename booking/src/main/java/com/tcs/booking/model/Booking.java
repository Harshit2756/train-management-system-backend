package com.tcs.booking.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bookingId;

  @Column(nullable = false, unique = true)
  private String pnr;

  @Column(nullable = false)
  private Long customerId;

  @Column(nullable = false)
  private Long trainId;

  @Column(nullable = false)
  private Long fromStationId;

  @Column(nullable = false)
  private Long toStationId;

  @Column(nullable = false)
  private LocalDate travelDate;

  @Column(nullable = false)
  private LocalTime departureTime;

  @Column(nullable = false)
  private LocalTime arrivalTime;

  @Column(nullable = false)
  private Integer totalPassengers;

  @Column(nullable = false)
  private BigDecimal totalAmount;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private BookingStatus status = BookingStatus.CONFIRMED;

  @Column(nullable = false)
  private LocalDateTime bookingDate;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  public Booking() {
    super();
  }

  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public String getPnr() {
    return pnr;
  }

  public void setPnr(String pnr) {
    this.pnr = pnr;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getTrainId() {
    return trainId;
  }

  public void setTrainId(Long trainId) {
    this.trainId = trainId;
  }

  public Long getFromStationId() {
    return fromStationId;
  }

  public void setFromStationId(Long fromStationId) {
    this.fromStationId = fromStationId;
  }

  public Long getToStationId() {
    return toStationId;
  }

  public void setToStationId(Long toStationId) {
    this.toStationId = toStationId;
  }

  public LocalDate getTravelDate() {
    return travelDate;
  }

  public void setTravelDate(LocalDate travelDate) {
    this.travelDate = travelDate;
  }

  public LocalTime getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(LocalTime departureTime) {
    this.departureTime = departureTime;
  }

  public LocalTime getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(LocalTime arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public Integer getTotalPassengers() {
    return totalPassengers;
  }

  public void setTotalPassengers(Integer totalPassengers) {
    this.totalPassengers = totalPassengers;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public BookingStatus getStatus() {
    return status;
  }

  public void setStatus(BookingStatus status) {
    this.status = status;
  }

  public LocalDateTime getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(LocalDateTime bookingDate) {
    this.bookingDate = bookingDate;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  
}
