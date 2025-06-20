package com.tcs.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.user.dto.ApiResponse;
import com.tcs.user.dto.PassengerDetailsDTO;
import com.tcs.user.service.PassengerService;

@RestController
@RequestMapping("/api/user/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping
    public ResponseEntity<ApiResponse<PassengerDetailsDTO>> addPassenger(
            @RequestParam Long userId,
            @RequestBody PassengerDetailsDTO passengerDTO) {
        PassengerDetailsDTO savedPassenger = passengerService.addPassenger(userId, passengerDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(savedPassenger, "Passenger added successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PassengerDetailsDTO>>> getPassengers(@RequestParam Long userId) {
        List<PassengerDetailsDTO> passengers = passengerService.getPassengers(userId);
        return ResponseEntity.ok(ApiResponse.success(passengers, "Passengers retrieved successfully"));
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<ApiResponse<PassengerDetailsDTO>> getPassenger(
            @RequestParam Long userId,
            @PathVariable Long passengerId) {
        PassengerDetailsDTO passenger = passengerService.getPassenger(userId, passengerId);
        return ResponseEntity.ok(ApiResponse.success(passenger, "Passenger retrieved successfully"));
    }

    @PutMapping("/{passengerId}")
    public ResponseEntity<ApiResponse<PassengerDetailsDTO>> updatePassenger(
            @RequestParam Long userId,
            @PathVariable Long passengerId,
            @RequestBody PassengerDetailsDTO passengerDTO) {
        PassengerDetailsDTO updatedPassenger = passengerService.updatePassenger(userId, passengerId, passengerDTO);
        return ResponseEntity.ok(ApiResponse.success(updatedPassenger, "Passenger updated successfully"));
    }

    @DeleteMapping("/{passengerId}")
    public ResponseEntity<ApiResponse<String>> deletePassenger(
            @RequestParam Long userId,
            @PathVariable Long passengerId) {
        passengerService.deletePassenger(userId, passengerId);
        return ResponseEntity.ok(ApiResponse.success(null, "Passenger deleted successfully"));
    }
}
