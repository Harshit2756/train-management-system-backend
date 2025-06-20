package com.tcs.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.food.dto.ApiResponse;
import com.tcs.food.dto.FoodOrderRequestDTO;
import com.tcs.food.dto.FoodOrderResponseDTO;
import com.tcs.food.service.FoodOrderService;

@RestController
@RequestMapping("/api/food/orders")
public class FoodOrderController {

    @Autowired
    private FoodOrderService foodOrderService;

    @PostMapping
    public ResponseEntity<ApiResponse<FoodOrderResponseDTO>> placeOrder(@RequestBody FoodOrderRequestDTO requestDTO) {
        return ResponseEntity.ok(ApiResponse.success(foodOrderService.placeOrder(requestDTO)));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<ApiResponse<FoodOrderResponseDTO>> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(ApiResponse.success(foodOrderService.getOrderById(orderId)));
    }

    @GetMapping("/history/{customerId}")
    public ResponseEntity<ApiResponse<List<FoodOrderResponseDTO>>> getOrderHistory(@PathVariable Long customerId) {
        return ResponseEntity.ok(ApiResponse.success(foodOrderService.getOrderHistory(customerId)));
    }
}
