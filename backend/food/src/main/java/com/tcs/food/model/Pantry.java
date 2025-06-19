package com.tcs.food.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "pantry")
public class Pantry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long pantryId;

  @Column(nullable = false)
  private Long trainId;

  @Column(nullable = false)
  private String pantryName;

  @Column(nullable = false)
  private String contactNumber;

  @Column(nullable = false)
  private Boolean isActive = true;

  @Column(nullable = false)
  private LocalTime serviceStartTime;

  @Column(nullable = false)
  private LocalTime serviceEndTime;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  public Pantry() {}

  // Getters and setters
  public Long getPantryId() {
    return pantryId;
  }

  public void setPantryId(Long pantryId) {
    this.pantryId = pantryId;
  }

  public Long getTrainId() {
    return trainId;
  }

  public void setTrainId(Long trainId) {
    this.trainId = trainId;
  }

  public String getPantryName() {
    return pantryName;
  }

  public void setPantryName(String pantryName) {
    this.pantryName = pantryName;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public LocalTime getServiceStartTime() {
    return serviceStartTime;
  }

  public void setServiceStartTime(LocalTime serviceStartTime) {
    this.serviceStartTime = serviceStartTime;
  }

  public LocalTime getServiceEndTime() {
    return serviceEndTime;
  }

  public void setServiceEndTime(LocalTime serviceEndTime) {
    this.serviceEndTime = serviceEndTime;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
