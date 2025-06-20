package com.tcs.food.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookingDTO {

    private Long bookingId;
    private Long customerId;
    private Long trainId;
    private LocalDate travelDate;
    private String status;
}
