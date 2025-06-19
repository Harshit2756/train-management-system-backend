package com.tcs.booking.dto;

import com.tcs.booking.model.SeatClass;
import com.tcs.booking.model.SeatType;
import java.math.BigDecimal;

public class SeatSelectionDTO {

  private Long passengerId;
  private SeatType seatType;
  private SeatClass seatClass;
  private String seatNumber;
  private BigDecimal fare;

  public SeatSelectionDTO() {
    super();
  }

  public Long getPassengerId() {
    return passengerId;
  }

  public void setPassengerId(Long passengerId) {
    this.passengerId = passengerId;
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

  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }

  public BigDecimal getFare() {
    return fare;
  }

  public void setFare(BigDecimal fare) {
    this.fare = fare;
  }
}
