package com.tcs.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.user.dto.ApiResponse;
import com.tcs.user.dto.UserProfileDTO;
import com.tcs.user.service.PassengerService;

@RestController
@RequestMapping("/api/user")
public class UserDashboardController {

    @Autowired
    private PassengerService passengerService;

    // @Autowired
    // private RestTemplate restTemplate;
    @GetMapping("/profile")
    public ResponseEntity<ApiResponse<UserProfileDTO>> getUserProfile(@RequestParam Long userId) {
        UserProfileDTO profile = passengerService.getUserProfile(userId);
        return ResponseEntity.ok(ApiResponse.success(profile, "User profile retrieved successfully"));
    }

    // @GetMapping("/trains")
    // public ResponseEntity<ApiResponse<Object>> getTrainSchedules(@RequestParam Long userId) {
    //     // Forward request to train service
    //     Object trainData = restTemplate.getForObject("http://train-service/api/trains", Object.class);
    //     return ResponseEntity.ok(ApiResponse.success(trainData, "Train schedules retrieved successfully"));
    // }
    // @GetMapping("/history")
    // public ResponseEntity<ApiResponse<Object>> getBookingHistory(@RequestParam Long userId) {
    //     // Forward request to booking service
    //     Object historyData = restTemplate.getForObject(
    //             "http://booking-service/api/bookings/history?userId=" + userId,
    //             Object.class
    //     );
    //     return ResponseEntity.ok(ApiResponse.success(historyData, "Booking history retrieved successfully"));
    // }
    // @GetMapping("/journey")
    // public ResponseEntity<ApiResponse<Object>> getUpcomingJourneys(@RequestParam Long userId) {
    //     // Forward request to booking service
    //     Object journeyData = restTemplate.getForObject(
    //             "http://booking-service/api/bookings/upcoming?userId=" + userId,
    //             Object.class
    //     );
    //     return ResponseEntity.ok(ApiResponse.success(journeyData, "Upcoming journeys retrieved successfully"));
    // }
}
