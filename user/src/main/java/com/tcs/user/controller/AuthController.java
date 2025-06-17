package com.tcs.user.controller;

import com.tcs.user.dto.AdminRegistrationDTO;
import com.tcs.user.dto.LoginDTO;
import com.tcs.user.dto.UserRegistrationDTO;
import com.tcs.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO dto) {
        authService.registerUser(dto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/admin/register")
    public ResponseEntity<String> registerAdmin(@RequestBody AdminRegistrationDTO dto) {
        authService.registerAdmin(dto);
        return ResponseEntity.ok("Admin registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
        String token = authService.login(dto);
        return ResponseEntity.ok(token);
    }
} 