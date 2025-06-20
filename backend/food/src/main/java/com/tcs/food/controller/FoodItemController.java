package com.tcs.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.food.dto.ApiResponse;
import com.tcs.food.model.FoodItem;
import com.tcs.food.service.FoodItemService;

@RestController
@RequestMapping("/api/food/items")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<FoodItem>>> getAvailableFoodItems() {
        return ResponseEntity.ok(ApiResponse.success(foodItemService.getAvailableFoodItems()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<FoodItem>> addFoodItem(@RequestBody FoodItem foodItem) {
        return ResponseEntity.ok(ApiResponse.success(foodItemService.addFoodItem(foodItem)));
    }
} 