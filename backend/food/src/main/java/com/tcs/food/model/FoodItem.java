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
@Table(name = "food_items")
public class FoodItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long foodItemId;

  @Column(nullable = false)
  private String itemName;

  @Column(nullable = false)
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private FoodCategory category;

  @Column(nullable = false)
  private BigDecimal price;

  @Column
  private String imageUrl;

  @Column(nullable = false)
  private Boolean isVegetarian;

  @Column(nullable = false)
  private Boolean isAvailable = true;

  @Column(nullable = false)
  private Integer preparationTime;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private LocalDateTime updatedAt;

  public FoodItem() {}

  // Getters and setters
  public Long getFoodItemId() {
    return foodItemId;
  }

  public void setFoodItemId(Long foodItemId) {
    this.foodItemId = foodItemId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public FoodCategory getCategory() {
    return category;
  }

  public void setCategory(FoodCategory category) {
    this.category = category;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Boolean getIsVegetarian() {
    return isVegetarian;
  }

  public void setIsVegetarian(Boolean isVegetarian) {
    this.isVegetarian = isVegetarian;
  }

  public Boolean getIsAvailable() {
    return isAvailable;
  }

  public void setIsAvailable(Boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public Integer getPreparationTime() {
    return preparationTime;
  }

  public void setPreparationTime(Integer preparationTime) {
    this.preparationTime = preparationTime;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
