package com.tcs.booking.model;

import java.math.BigDecimal;
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
@Table(name = "payments")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long paymentId;

  @Column(nullable = false)
  private Long bookingId;

  @Column(nullable = false, unique = true)
  private String transactionId;

  @Column(nullable = false)
  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PaymentMethod paymentMethod;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PaymentStatus status = PaymentStatus.PENDING;

  @Column(nullable = false)
  private LocalDateTime paymentDate;

  @Column
  private String gatewayResponse;

  public Payment() {
      super();
  }

  public Long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public PaymentStatus getStatus() {
    return status;
  }

  public void setStatus(PaymentStatus status) {
    this.status = status;
  }

  public LocalDateTime getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(LocalDateTime paymentDate) {
    this.paymentDate = paymentDate;
  }

  public String getGatewayResponse() {
    return gatewayResponse;
  }

  public void setGatewayResponse(String gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
  }
  
  
}
