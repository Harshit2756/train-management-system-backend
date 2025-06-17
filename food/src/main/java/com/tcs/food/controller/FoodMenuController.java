package com.tcs.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.food.dto.FoodItemDTO;
import com.tcs.food.service.FoodMenuService;

@RestController
@RequestMapping("/api/food_cart")
public class FoodMenuController {

  @Autowired
  private FoodMenuService foodMenuService;

  @GetMapping
  public ResponseEntity<List<FoodItemDTO>> getAllFoodItems() {
    List<FoodItemDTO> items = foodMenuService.getAllFoodItems();
    return ResponseEntity.ok(items);
  }

  @GetMapping("/{trainId}")
  public ResponseEntity<List<FoodItemDTO>> getFoodItemsByTrain(
    @PathVariable Long trainId
  ) {
    List<FoodItemDTO> items = foodMenuService.getFoodItemsByTrain(trainId);
    return ResponseEntity.ok(items);
  }

  @PostMapping("/admin/food_items")
  public ResponseEntity<FoodItemDTO> addFoodItem(
    @RequestBody FoodItemDTO foodItemDTO
  ) {
    FoodItemDTO created = foodMenuService.addFoodItem(foodItemDTO);
    return ResponseEntity.status(201).body(created);
  }

  @PutMapping("/admin/food_items/{itemId}")
  public ResponseEntity<FoodItemDTO> updateFoodItem(
    @PathVariable Long itemId,
    @RequestBody FoodItemDTO foodItemDTO
  ) {
    FoodItemDTO updated = foodMenuService.updateFoodItem(itemId, foodItemDTO);
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/admin/food_items/{itemId}")
  public ResponseEntity<Void> deleteFoodItem(@PathVariable Long itemId) {
    foodMenuService.deleteFoodItem(itemId);
    return ResponseEntity.noContent().build();
  }
}
