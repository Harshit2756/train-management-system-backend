package com.tcs.food.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.food.dto.ApiResponse;
import com.tcs.food.dto.BookingDTO;

@FeignClient(name = "booking-service", path = "/api/booking")
public interface BookingServiceClient {

    @GetMapping("/{bookingId}")
    ApiResponse<BookingDTO> getBookingById(@PathVariable("bookingId") Long bookingId);
} 