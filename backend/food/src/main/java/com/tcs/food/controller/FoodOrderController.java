package com.tcs.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.food.dto.FoodInventoryDTO;
import com.tcs.food.dto.FoodOrderDTO;
import com.tcs.food.service.FoodInventoryService;
import com.tcs.food.service.FoodOrderService;

@RestController
@RequestMapping("/api/food_order")
public class FoodOrderController {

    @Autowired
    private FoodOrderService foodOrderService;

    @Autowired
    private FoodInventoryService foodInventoryService;

    @PostMapping
    public ResponseEntity<FoodOrderDTO> placeOrder(@RequestBody FoodOrderDTO orderDTO) {
        FoodOrderDTO created = foodOrderService.placeOrder(orderDTO);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<FoodOrderDTO> getOrderById(@PathVariable Long orderId) {
        FoodOrderDTO order = foodOrderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long orderId) {
        foodOrderService.cancelOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<FoodOrderDTO>> getOrdersByCustomer(@PathVariable Long customerId) {
        List<FoodOrderDTO> orders = foodOrderService.getOrdersByCustomer(customerId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/inventory/{pantryId}")
    public ResponseEntity<List<FoodInventoryDTO>> getInventoryByPantry(@PathVariable Long pantryId) {
        List<FoodInventoryDTO> inventory = foodInventoryService.getInventoryByPantry(pantryId);
        return ResponseEntity.ok(inventory);
    }
} 