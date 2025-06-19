package com.tcs.food.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "food_orders")
public class FoodOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  @Column(nullable = false, unique = true)
  private String orderNumber;

  @Column(nullable = false)
  private Long customerId;

  @Column(nullable = false)
  private String pnr;

  @Column(nullable = false)
  private String seatNumber;

  @Column(nullable = false)
  private Long trainId;

  @Column(nullable = false)
  private BigDecimal totalAmount;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private OrderStatus status = OrderStatus.PLACED;

  @Column(nullable = false)
  private LocalDateTime orderTime;

  @Column
  private LocalDateTime deliveryTime;

  @Column
  private String specialInstructions;

  public FoodOrder() {}

  // Getters and setters
  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getPnr() {
    return pnr;
  }

  public void setPnr(String pnr) {
    this.pnr = pnr;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }

  public Long getTrainId() {
    return trainId;
  }

  public void setTrainId(Long trainId) {
    this.trainId = trainId;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public LocalDateTime getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(LocalDateTime orderTime) {
    this.orderTime = orderTime;
  }

  public LocalDateTime getDeliveryTime() {
    return deliveryTime;
  }

  public void setDeliveryTime(LocalDateTime deliveryTime) {
    this.deliveryTime = deliveryTime;
  }

  public String getSpecialInstructions() {
    return specialInstructions;
  }

  public void setSpecialInstructions(String specialInstructions) {
    this.specialInstructions = specialInstructions;
  }
}
