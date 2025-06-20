package com.tcs.food.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.tcs.food.model.OrderStatus;

import lombok.Data;

@Data
public class FoodOrderResponseDTO {

    private Long id;
    private Long bookingId;
    private Long customerId;
    private List<OrderItemResponseDTO> orderItems;
    private Double totalAmount;
    private OrderStatus status;
    private LocalDateTime orderDate;
    private LocalDateTime estimatedDeliveryTime;
}
