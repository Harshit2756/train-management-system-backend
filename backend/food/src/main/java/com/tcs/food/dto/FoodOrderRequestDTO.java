package com.tcs.food.dto;

import java.util.List;

import lombok.Data;


@Data
public class FoodOrderRequestDTO {
    private Long customerId;
    private Long bookingId;
    private List<OrderItemDTO> items;
}