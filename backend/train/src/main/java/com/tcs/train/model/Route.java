package com.tcs.train.model;

import java.math.BigDecimal;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "routes")
public class Route {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long routeId;

  @Column(nullable = false)
  private Long trainId;

  @Column(nullable = false)
  private Long fromStationId;

  @Column(nullable = false)
  private Long toStationId;

  @Column(nullable = false)
  private Integer distance;

  @Column(nullable = false)
  private Integer sequenceNumber;

  @Column(nullable = false)
  private LocalTime arrivalTime;

  @Column(nullable = false)
  private LocalTime departureTime;

  @Column(nullable = false)
  private Integer stopDuration;

  @Column(nullable = false)
  private BigDecimal acFare;

  @Column(nullable = false)
  private BigDecimal sleeperFare;

  @Column(nullable = false)
  private BigDecimal generalFare;

  public Route() {
    super();
  }

  public Long getRouteId() {
    return routeId;
  }

  public void setRouteId(Long routeId) {
    this.routeId = routeId;
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

  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public Integer getSequenceNumber() {
    return sequenceNumber;
  }

  public void setSequenceNumber(Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  public LocalTime getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(LocalTime arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public LocalTime getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(LocalTime departureTime) {
    this.departureTime = departureTime;
  }

  public Integer getStopDuration() {
    return stopDuration;
  }

  public void setStopDuration(Integer stopDuration) {
    this.stopDuration = stopDuration;
  }

  public BigDecimal getAcFare() {
    return acFare;
  }

  public void setAcFare(BigDecimal acFare) {
    this.acFare = acFare;
  }

  public BigDecimal getSleeperFare() {
    return sleeperFare;
  }

  public void setSleeperFare(BigDecimal sleeperFare) {
    this.sleeperFare = sleeperFare;
  }

  public BigDecimal getGeneralFare() {
    return generalFare;
  }

  public void setGeneralFare(BigDecimal generalFare) {
    this.generalFare = generalFare;
  }
}
