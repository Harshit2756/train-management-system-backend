package com.tcs.train.dto;

import java.math.BigDecimal;
import java.time.LocalTime;

public class RouteDTO {

  private Long routeId;
  private Long trainId;
  private Long fromStationId;
  private Long toStationId;
  private Integer distance;
  private Integer sequenceNumber;
  private LocalTime arrivalTime;
  private LocalTime departureTime;
  private Integer stopDuration;
  private BigDecimal acFare;
  private BigDecimal sleeperFare;
  private BigDecimal generalFare;

  public RouteDTO() {
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
