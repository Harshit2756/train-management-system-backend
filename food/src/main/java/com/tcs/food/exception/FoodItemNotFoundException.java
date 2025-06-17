package com.tcs.food.exception;

public class FoodItemNotFoundException extends RuntimeException {

  public FoodItemNotFoundException(String message) {
    super(message);
  }
}
