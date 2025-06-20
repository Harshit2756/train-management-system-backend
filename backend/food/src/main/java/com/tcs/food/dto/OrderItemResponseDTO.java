package com.tcs.food.dto;

import lombok.Data;

@Data
public class OrderItemResponseDTO {

    private String foodItemName;
    private int quantity;
    private Double price;
}
