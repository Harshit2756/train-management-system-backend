package com.tcs.train.exception;

public class TrainNotFoundException extends RuntimeException {

  public TrainNotFoundException(String message) {
    super(message);
  }
}
