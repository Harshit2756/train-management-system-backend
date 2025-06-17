package com.tcs.food.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "food_inventory")
public class FoodInventory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long inventoryId;

  @Column(nullable = false)
  private Long pantryId;

  @Column(nullable = false)
  private Long foodItemId;

  @Column(nullable = false)
  private Integer availableQuantity;

  @Column(nullable = false)
  private LocalDate inventoryDate;

  @Column(nullable = false)
  private LocalDateTime lastUpdated;

  public FoodInventory() {}

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
