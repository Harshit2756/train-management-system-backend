package com.tcs.food.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FoodInventoryDTO {

  private Long inventoryId;
  private Long pantryId;
  private Long foodItemId;
  private Integer availableQuantity;
  private LocalDate inventoryDate;
  private LocalDateTime lastUpdated;

  public FoodInventoryDTO() {}

  // Getters and setters
  public Long getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(Long inventoryId) {
    this.inventoryId = inventoryId;
  }

  public Long getPantryId() {
    return pantryId;
  }

  public void setPantryId(Long pantryId) {
    this.pantryId = pantryId;
  }

  public Long getFoodItemId() {
    return foodItemId;
  }

  public void setFoodItemId(Long foodItemId) {
    this.foodItemId = foodItemId;
  }

  public Integer getAvailableQuantity() {
    return availableQuantity;
  }

  public void setAvailableQuantity(Integer availableQuantity) {
    this.availableQuantity = availableQuantity;
  }

  public LocalDate getInventoryDate() {
    return inventoryDate;
  }

  public void setInventoryDate(LocalDate inventoryDate) {
    this.inventoryDate = inventoryDate;
  }

  public LocalDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(LocalDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }
}
