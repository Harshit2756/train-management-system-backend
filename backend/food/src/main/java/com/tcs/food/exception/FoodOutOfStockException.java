package com.tcs.food.exception;

public class FoodOutOfStockException extends RuntimeException {

  public FoodOutOfStockException(String message) {
    super(message);
  }
}
