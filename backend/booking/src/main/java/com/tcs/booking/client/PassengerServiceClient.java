package com.tcs.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.booking.dto.ApiResponse;
import com.tcs.booking.dto.PassengerDTO;

@FeignClient(name = "user-service", url = "${user.service.url}")
public interface PassengerServiceClient {

    @GetMapping("/api/passengers/{passengerId}")
    ApiResponse<PassengerDTO> getPassengerById(@PathVariable("passengerId") Long passengerId, @RequestParam("userId") Long userId);

}
