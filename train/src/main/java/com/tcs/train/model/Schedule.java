package com.tcs.train.model;

import java.time.LocalDate;
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
@Table(name = "schedules")
public class Schedule {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long scheduleId;

  @Column(nullable = false)
  private Long trainId;

  @Column(nullable = false)
  private LocalDate travelDate;

  @Column(nullable = false)
  private Integer availableAcSeats;

  @Column(nullable = false)
  private Integer availableSleeperSeats;

  @Column(nullable = false)
  private Integer availableGeneralSeats;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ScheduleStatus status = ScheduleStatus.SCHEDULED;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private LocalDateTime updatedAt;

  public Schedule() {
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

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
