package com.tcs.food.dto;

import java.util.List;

public class FoodCartDTO {

  private List<FoodItemDTO> items;
  private Long trainId;

  public FoodCartDTO() {}

  // Getters and setters
  public List<FoodItemDTO> getItems() {
    return items;
  }

  public void setItems(List<FoodItemDTO> items) {
    this.items = items;
  }

  public Long getTrainId() {
    return trainId;
  }

  public void setTrainId(Long trainId) {
    this.trainId = trainId;
  }
}
