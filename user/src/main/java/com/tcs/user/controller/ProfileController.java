package com.tcs.user.controller;

import com.tcs.user.dto.UserProfileDTO;
import com.tcs.user.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfileController {

  @Autowired
  private UserService userService;

  @GetMapping("/profile")
  public ResponseEntity<UserProfileDTO> getProfile(@RequestParam String email) {
    return ResponseEntity.ok(userService.getProfile(email));
  }

  @PutMapping("/profile")
  public ResponseEntity<String> updateProfile(
    @RequestParam String email,
    @RequestBody UserProfileDTO dto
  ) {
    userService.updateProfile(email, dto);
    return ResponseEntity.ok("Profile updated successfully");
  }

  @GetMapping("/history")
  public ResponseEntity<List<String>> getBookingHistory(
    @RequestParam String email
  ) {
    return ResponseEntity.ok(userService.getBookingHistory(email));
  }

  @GetMapping("/journey")
  public ResponseEntity<List<String>> getUpcomingJourneys(
    @RequestParam String email
  ) {
    return ResponseEntity.ok(userService.getUpcomingJourneys(email));
  }
}
