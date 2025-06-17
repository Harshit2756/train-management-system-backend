package com.tcs.train.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stations")
public class Station {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long stationId;

  @Column(nullable = false, unique = true)
  private String stationCode;

  @Column(nullable = false)
  private String stationName;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private String state;

  @Column
  private String zone;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private StationStatus status = StationStatus.ACTIVE;

  public Station() {
    super();
  }

  public Long getStationId() {
    return stationId;
  }

  public void setStationId(Long stationId) {
    this.stationId = stationId;
  }

  public String getStationCode() {
    return stationCode;
  }

  public void setStationCode(String stationCode) {
    this.stationCode = stationCode;
  }

  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZone() {
    return zone;
  }

  public void setZone(String zone) {
    this.zone = zone;
  }

  public StationStatus getStatus() {
    return status;
  }

  public void setStatus(StationStatus status) {
    this.status = status;
  }
}
