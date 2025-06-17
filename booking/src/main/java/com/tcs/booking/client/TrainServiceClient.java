package com.tcs.booking.client;

import org.springframework.stereotype.Component;

@Component
public class TrainServiceClient {

  public boolean validateTrain(Long trainId) {
    // Dummy implementation: always return true
    return true;
  }
}
