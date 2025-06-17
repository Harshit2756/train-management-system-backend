package com.tcs.booking.exception;

public class PaymentFailedException extends RuntimeException {

  public PaymentFailedException(String message) {
    super(message);
  }
}
