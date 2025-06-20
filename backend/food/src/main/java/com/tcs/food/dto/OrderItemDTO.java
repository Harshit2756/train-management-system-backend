package com.tcs.food.dto;

import lombok.Data;

@Data
public class OrderItemDTO {

    private Long foodItemId;
    private int quantity;
}
