package com.tcs.train.dto;

import java.time.LocalDate;

import com.tcs.train.model.ScheduleStatus;

public class ScheduleDTO {

  private Long scheduleId;
  private Long trainId;
  private LocalDate travelDate;
  private Integer availableAcSeats;
  private Integer availableSleeperSeats;
  private Integer availableGeneralSeats;
  private ScheduleStatus status;

  public ScheduleDTO() {
    super();
  }

  public Long getScheduleId() {
    return scheduleId;
  }

  public void setScheduleId(Long scheduleId) {
    this.scheduleId = scheduleId;
  }

  public Long getTrainId() {
    return trainId;
  }

  public void setTrainId(Long trainId) {
    this.trainId = trainId;
  }

  public LocalDate getTravelDate() {
    return travelDate;
  }

  public void setTravelDate(LocalDate travelDate) {
    this.travelDate = travelDate;
  }

  public Integer getAvailableAcSeats() {
    return availableAcSeats;
  }

  public void setAvailableAcSeats(Integer availableAcSeats) {
    this.availableAcSeats = availableAcSeats;
  }

  public Integer getAvailableSleeperSeats() {
    return availableSleeperSeats;
  }

  public void setAvailableSleeperSeats(Integer availableSleeperSeats) {
    this.availableSleeperSeats = availableSleeperSeats;
  }

  public Integer getAvailableGeneralSeats() {
    return availableGeneralSeats;
  }

  public void setAvailableGeneralSeats(Integer availableGeneralSeats) {
    this.availableGeneralSeats = availableGeneralSeats;
  }

  public ScheduleStatus getStatus() {
    return status;
  }

  public void setStatus(ScheduleStatus status) {
    this.status = status;
  }

   
}
