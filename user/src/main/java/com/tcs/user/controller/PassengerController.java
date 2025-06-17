package com.tcs.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.tcs.user.dto.PassengerDetailsDTO;
import com.tcs.user.service.PassengerService;

@RestController
@RequestMapping("/api/passenger_details")
public class PassengerController {

  @Autowired
  private PassengerService passengerService;

  @PostMapping
  public ResponseEntity<String> addPassenger(
    @RequestParam Long customerId,
    @RequestBody PassengerDetailsDTO dto
  ) {
    passengerService.addPassenger(customerId, dto);
    return ResponseEntity.ok("Passenger added successfully");
  }

  @GetMapping
  public ResponseEntity<List<PassengerDetailsDTO>> getPassengers(
    @RequestParam Long customerId
  ) {
    return ResponseEntity.ok(passengerService.getPassengers(customerId));
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updatePassenger(
    @PathVariable Long id,
    @RequestBody PassengerDetailsDTO dto
  ) {
    passengerService.updatePassenger(id, dto);
    return ResponseEntity.ok("Passenger updated successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePassenger(@PathVariable Long id) {
    passengerService.deletePassenger(id);
    return ResponseEntity.ok("Passenger deleted successfully");
  }
}
