package com.tcs.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "passenger_details")
public class PassengerDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long passengerId;

  @Column(nullable = false)
  private Long customerId;

  @Column(nullable = false)
  private String fullName;

  @Column(nullable = false)
  private Integer age;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Gender gender;

  @Column
  private String idProofType;

  @Column
  private String idProofNumber;

  @Column
  private String nationality;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private LocalDateTime updatedAt;

  public PassengerDetails() {}

  public PassengerDetails(
    Long customerId,
    String fullName,
    Integer age,
    Gender gender,
    String idProofType,
    String idProofNumber,
    String nationality,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
  ) {
    this.customerId = customerId;
    this.fullName = fullName;
    this.age = age;
    this.gender = gender;
    this.idProofType = idProofType;
    this.idProofNumber = idProofNumber;
    this.nationality = nationality;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Long getPassengerId() {
    return passengerId;
  }

  public void setPassengerId(Long passengerId) {
    this.passengerId = passengerId;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getIdProofType() {
    return idProofType;
  }

  public void setIdProofType(String idProofType) {
    this.idProofType = idProofType;
  }

  public String getIdProofNumber() {
    return idProofNumber;
  }

  public void setIdProofNumber(String idProofNumber) {
    this.idProofNumber = idProofNumber;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
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
