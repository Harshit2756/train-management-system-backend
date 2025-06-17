package com.tcs.booking.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class BookingRequestDTO {

  private Long customerId;
  private Long trainId;
  private Long fromStationId;
  private Long toStationId;
  private LocalDate travelDate;
  private LocalTime departureTime;
  private LocalTime arrivalTime;
  private Integer totalPassengers;
  private List<Long> passengerIds;
  private List<SeatSelectionDTO> seatSelections;
  private BigDecimal totalAmount;

  public BookingRequestDTO() {
    super();
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

  public List<Long> getPassengerIds() {
    return passengerIds;
  }

  public void setPassengerIds(List<Long> passengerIds) {
    this.passengerIds = passengerIds;
  }

  public List<SeatSelectionDTO> getSeatSelections() {
    return seatSelections;
  }

  public void setSeatSelections(List<SeatSelectionDTO> seatSelections) {
    this.seatSelections = seatSelections;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  
}
